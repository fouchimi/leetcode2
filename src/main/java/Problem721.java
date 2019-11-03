import java.util.*;

public class Problem721 {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> map = new HashMap<>();
        Map<String, Boolean> visitedMap = new HashMap<>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i++) {
                if (!map.containsKey(account.get(i))) map.put(account.get(i), new ArrayList<>());
                for (int j = i+1; j < account.size(); j++) {
                    if (!map.containsKey(account.get(j))) map.put(account.get(j), new ArrayList<>());
                    map.get(account.get(i)).add(account.get(j));
                    map.get(account.get(j)).add(account.get(i));
                }
                if (!map.get(account.get(i)).contains(account.get(0))) map.get(account.get(i)).add(0, account.get(0));
                visitedMap.put(account.get(i), false);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            if (!visitedMap.get(entry.getKey())) {
                List<String> list = new ArrayList<>();
                dfs(entry.getKey(), map, visitedMap, list);
                list.sort(Comparator.naturalOrder());
                list.add(0, map.get(entry.getKey()).get(0));
                res.add(list);
            }
        }
        return res;
    }

    private void dfs(String src, Map<String, List<String>> map, Map<String, Boolean> visited, List<String> list) {
        visited.put(src, true);
        list.add(src);
        for (String neighbor : map.get(src)) {
            if (!neighbor.contains("@")) continue;
            if (!visited.get(neighbor)) dfs(neighbor, map, visited, list);

        }
    }

    public static void main(String[] args) {
        Problem721 problem721 = new Problem721();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com"), Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"));
        List<List<String>> res = problem721.accountsMerge(accounts);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
