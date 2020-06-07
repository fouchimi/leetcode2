import java.util.LinkedHashMap;
import java.util.Map;

public class Problem76 {
    public String minWindow(String s, String t) {
        int min = Integer.MAX_VALUE, start = 0, startIndex = 0, matches = 0;
        Map<Character, Integer> frequencies = new LinkedHashMap<>();

        for(int i = 0; i < t.length();  i++){
            char ch = t.charAt(i);
            frequencies.put(ch, frequencies.getOrDefault(ch, 0) + 1);
        }

        for (int end = 0; end < s.length() ; end++){
            char rightChar = s.charAt(end);
            if (frequencies.containsKey(rightChar)) {
                frequencies.put(rightChar, frequencies.get(rightChar) - 1);
                if (frequencies.get(rightChar) >= 0) matches++;
            }

            while (matches == t.length()) {
                if (min > end - start + 1) {
                    min = end - start + 1;
                    startIndex = start;
                }

                char leftChar = s.charAt(start++);
                if (frequencies.containsKey(leftChar)) {
                    if (frequencies.get(leftChar) == 0) matches--;
                    frequencies.put(leftChar, frequencies.get(leftChar) + 1);
                }

            }
        }

        return min == Integer.MAX_VALUE ? "" : s.substring(startIndex, min + startIndex);
    }

    public static void main(String[] args) {
        Problem76 problem76 = new Problem76();
        System.out.println(problem76.minWindow("ADOBECODEBANC", "ABC"));
    }
}
