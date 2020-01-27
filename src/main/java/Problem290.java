import java.util.LinkedHashMap;
import java.util.Map;

public class Problem290 {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> firstMap = new LinkedHashMap<>();
        Map<String, Character> secondMap = new LinkedHashMap<>();
        char[] chars = pattern.toCharArray();
        String[] strs = str.split(" ");
        if (chars.length != strs.length) return false;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if ((firstMap.containsKey(ch) && !firstMap.get(ch).equals(strs[i])) ||
                    (secondMap.containsKey(strs[i]) && secondMap.get(strs[i]) != ch)) return false;
            firstMap.put(ch, strs[i]);
            secondMap.put(strs[i], ch);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem290 problem290 = new Problem290();
        System.out.println(problem290.wordPattern("abba", "dog cat cat dog"));
        System.out.println(problem290.wordPattern("abba", "dog cat cat fish"));
        System.out.println(problem290.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(problem290.wordPattern("abba", "dog dog dog dog"));
    }
}
