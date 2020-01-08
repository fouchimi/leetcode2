import java.util.*;

public class Problem187 {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        for (int i = 0; i + 10 <= s.length(); i++) {
            String key = s.substring(i, i + 10);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) res.add(entry.getKey());
        }
        return res;
    }

    public static void main(String[] args) {
        Problem187 problem187 = new Problem187();
        System.out.println(problem187.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
        System.out.println(problem187.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
