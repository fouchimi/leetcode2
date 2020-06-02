import java.util.*;

public class Problem1169 {

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<String>> map = new HashMap<>();
        List<String> ans = new ArrayList<>();
        Set<String> invalidTransactions = new LinkedHashSet<>();
        for (String transaction : transactions) {
            String[] transactionsDetails = transaction.split(",");
            String key = transactionsDetails[0];
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(transaction);
        }

        for (String key : map.keySet()) {
            List<String> currentTransactionList = map.get(key);
            currentTransactionList.sort((firstTransaction, secondTransaction) -> {
                String[] firstTranDetails = firstTransaction.split(",");
                String[] secondTranDetails = secondTransaction.split(",");
                int timeOne = Integer.parseInt(firstTranDetails[1]), timeTwo = Integer.parseInt(secondTranDetails[1]);
                return timeOne - timeTwo;
            });
            for(int i = 0; i < currentTransactionList.size(); i++) {
                String[] iDetails = currentTransactionList.get(i).split(",");
                if (exceedThousands(iDetails[2])) invalidTransactions.add(currentTransactionList.get(i));
                for (int j = i + 1; j < currentTransactionList.size(); j++) {
                    String[] jDetails = currentTransactionList.get(j).split(",");
                    int iTime = Integer.parseInt(iDetails[1]);
                    int jTime = Integer.parseInt(jDetails[1]);
                    if (exceedThousands(jDetails[2])) {
                        invalidTransactions.add(currentTransactionList.get(j));
                    }
                    if ((jTime - iTime <= 60 && !iDetails[3].equals(jDetails[3]))) {
                        invalidTransactions.add(currentTransactionList.get(i));
                        invalidTransactions.add(currentTransactionList.get(j));
                    }

                }
            }
        }
        if (!invalidTransactions.isEmpty()) ans.addAll(invalidTransactions);
        return ans;
    }

    private boolean exceedThousands(String amount) {
        return Integer.parseInt(amount) > 1000;
    }

    public static void main(String[] args) {
        Problem1169 problem1169 = new Problem1169();
        System.out.println(problem1169.invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"}));
        System.out.println(problem1169.invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,1200,mtv"}));
        System.out.println(problem1169.invalidTransactions(new String[]{"alice,20,800,mtv","bob,50,1200,mtv"}));
        System.out.println(problem1169.invalidTransactions(new String[]{"bob,689,1910,barcelona","alex,696,122,bangkok","bob,832,1726,barcelona","bob,820,596,bangkok","chalicefy,217,669,barcelona","bob,175,221,amsterdam"}));
    }
}
