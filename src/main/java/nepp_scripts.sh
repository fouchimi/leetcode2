#!/bin/bash

source "init.sh"

echo "USERNAME: $MTT_USERNAME"
echo "PASSWORD: $MTT_PASSWORD"
echo "ORDER_PREFIX_ID: $ORDER_PREFIX_ID"

for babyScript in data/*.sh; do
  unset body
  # source beforeTest.sh
  filename=$(basename $babyScript)
  ## Removing extension and prepending ORDER_PREFIX_ID
  orderId=$ORDER_PREFIX_ID$(echo "$filename" | cut -f 1 -d '.')

  source "${babyScript}"

  authorizeUrl="${BASE_INT_URL}/api/paymentservice/v3/authorizeOrder"
  activateUrl="${BASE_INT_URL}/api/paymentservice/v3/activateOrder"

  if ($body | $authorizeUrl | $activateUrl)
  then
    echo "*** parameter missing script skipped! ${babyScript}"
    exit 1
  else
    echo "ORDER ID: $orderId"
    echo "AUTHORIZE URL: $authorizeUrl"
    echo "BODY: $body"
    authorizeOrderOutput=$(curl -i  --user "$MTT_USERNAME:$MTT_PASSWORD"  --location --request POST "$authorizeUrl" \
    --header 'nord-request-id: test-458' \
    --header 'nord-country-code: CA' \
    --header 'nord-client-id: APP01766' \
    --header 'nord-entity: NORD' \
    --header 'Content-Type: application/json' \
    --data-raw "$body" | json)

    echo "AUTHORIZE OUTPUT: $authorizeOrderOutput"

    activateOrderOutput=$(curl -i  --user "$MTT_USERNAME:$MTT_PASSWORD"  --location --request POST "$activateUrl" \
    --header 'nord-request-id: test-458' \
    --header 'nord-country-code: CA' \
    --header 'nord-client-id: APP01766' \
    --header 'nord-entity: NORD' \
    --header 'Content-Type: application/json' \
    --data-raw "$body" | json)

    echo "ACTIVATE OUTPUT: $activateOrderOutput"

  fi
done