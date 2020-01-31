import java.util.HashMap;
import java.util.Map;

public class Problem345 {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int N = chars.length;
        int i = 0, j = N - 1;
        Map<Character, Integer> vowelsMap = new HashMap<>();
        vowelsMap.put('a', 1);
        vowelsMap.put('A', 1);
        vowelsMap.put('e', 1);
        vowelsMap.put('E', 1);
        vowelsMap.put('o', 1);
        vowelsMap.put('O', 1);
        vowelsMap.put('u', 1);
        vowelsMap.put('U', 1);
        vowelsMap.put('i', 1);
        vowelsMap.put('I', 1);
        while (i < j) {
            while (i < N && !vowelsMap.containsKey(chars[i])) i++;
            while (j > 0 && !vowelsMap.containsKey(chars[j])) j--;
            if (i >= j) break;
            char tempChar = chars[i];
            chars[i] = chars[j];
            chars[j] = tempChar;
            i++;
            j--;
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < N; k++) sb.append(chars[k]);
        return sb.toString();
    }

    public static void main(String[] args) {
        Problem345 problem345 = new Problem345();
        System.out.println(problem345.reverseVowels("hello"));
        System.out.println(problem345.reverseVowels("leetcode"));
    }
}
