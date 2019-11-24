import java.util.*;

public class Problem49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs == null || strs.length == 0) return res;

        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] strChars = str.toCharArray();
            Arrays.sort(strChars);
            String newStr = new String(strChars);
            if (map.containsKey(newStr)) map.get(newStr).add(str);
            else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(newStr, list);
            }
        }

        for (String key : map.keySet()) res.add(map.get(key));
        return res;
    }

    public static void main(String[] args) {
        Problem49 problem49 = new Problem49();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> res = problem49.groupAnagrams(strs);
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
