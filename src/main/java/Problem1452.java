import java.util.*;

public class Problem1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<Integer, Set<String>> map = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i<favoriteCompanies.size(); i++) map.put(i, new HashSet<>(favoriteCompanies.get(i)));

        for (int i = 0; i<favoriteCompanies.size(); i++){
            List<String> companies = favoriteCompanies.get(i);
            boolean found = false;

            for (Map.Entry<Integer, Set<String>> entry : map.entrySet()){
                if (entry.getKey() == i || entry.getValue().size() < companies.size()) continue;

                if (entry.getValue().containsAll(companies)){
                    found = true;
                    break;
                }
            }

            if (!found)
                res.add(i);
        }

        return res;
    }

    private void print(List<Integer> list) {
        for (int val : list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1452 problem1452 = new Problem1452();
        problem1452.print(problem1452.peopleIndexes(Arrays.asList(Arrays.asList("leetcode", "google", "facebook"),
                Arrays.asList("google", "microsoft"), Arrays.asList("google", "facebook"), Collections.singletonList("google"), Collections.singletonList("amazon"))));
        problem1452.print(problem1452.peopleIndexes(Arrays.asList(Arrays.asList("arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","zibvccaoayyihidztflj"),
                Arrays.asList("cffiqfviuwjowkppdajm","owqvnrhuzwqohquamvsz"),
                Arrays.asList("knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl"),
                Arrays.asList("arrtztkotazhufrsfczr","cffiqfviuwjowkppdajm"),
                Arrays.asList("arrtztkotazhufrsfczr","knzgidixqgtnahamebxf","owqvnrhuzwqohquamvsz","qzeqyrgnbplsrgqnplnl","zibvccaoayyihidztflj"))));

    }
}
