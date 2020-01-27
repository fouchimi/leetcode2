import java.util.LinkedHashMap;
import java.util.Map;

public class Problem387 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        Map<Character, Integer> indexMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            indexMap.put(ch, i);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) return indexMap.get(entry.getKey());
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem387 problem387 = new Problem387();
        System.out.println(problem387.firstUniqChar("leetcode"));
        System.out.println(problem387.firstUniqChar("loveleetcode"));
    }
}
