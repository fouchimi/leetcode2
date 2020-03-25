echo "Hi from baby script ${ORDER_ID_PREFIX}"

body=$(cat <<EOF
{
    "order": {
        "iconId": "e73be096-ec44-47c2-8845-121804677ce1",
        "entityShopperId": "FCE6562EFD994570BE88EDB9C4B2F88D",
        "orderId": "$orderId",
        "currency": "CAD",
        "totalAmount": 26.4,
        "quantity": 1,
        "createdTime": "2020-02-12T02:04:39.343Z",
        "deliveryMethod": "STANDARD_SHIPPING"
    },
    "shippingAddress": null,
    "billingAddress": {
        "firstName": "Mary",
        "lastName": "Jane",
        "addressLine1": "1302 2nd ave",
        "addressLine2": null,
        "city": "seattle",
        "country": "US",
        "postalCode": "98101",
        "phone": "4253332222",
        "email": "buynow1@nord.com"
    },
    "cardTender": {
        "type": "CREDIT_CARD",
        "token": "4445229416360007",
        "tokenIssuer": "VANTIV",
        "tokenType": "HVT",
        "cardType": "VC",
        "cardSubType": null,
        "expirationDate": "12-2025",
        "amount": 26.4,
        "credentialOnFile": "S"
    },
    "gcNoteTenders": []
}
EOF
)
