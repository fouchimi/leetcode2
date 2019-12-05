import java.util.*;

public class Problem451 {

    public String frequencySort(String s) {
        if (s == null || s.length() == 0) return "";
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1 );
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());
        Collections.sort(list, (first, second) -> {
           if (first.getValue() < second.getValue()) return 1;
           else if (first.getValue() > second.getValue()) return -1;
           return first.getKey().compareTo(second.getKey());
        });

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> entry : list) {
            int k = entry.getValue();
            while (k > 0) {
                sb.append(entry.getKey());
                k--;
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem451 problem451 = new Problem451();
        System.out.println(problem451.frequencySort("tree"));
    }
}
