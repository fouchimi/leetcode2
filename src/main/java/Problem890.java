import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem890 {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> res = new ArrayList<>();
        if (words == null || pattern == null || words.length == 0 || pattern.length() == 0) return res;
        for (String word : words) {
            if (word.length() != pattern.length()) continue;
            Map<Character, Character> keyMap = new HashMap<>();
            Map<Character, Character> valueMap = new HashMap<>();
            int i = 0;
            for (; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (keyMap.containsKey(ch) && keyMap.get(ch) != pattern.charAt(i)) break;
                if (valueMap.containsKey(pattern.charAt(i)) && valueMap.get(pattern.charAt(i)) != ch) break;
                keyMap.put(ch, pattern.charAt(i));
                valueMap.put(pattern.charAt(i), ch);
            }
            if (i == word.length()) res.add(word);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem890 problem890 = new Problem890();
        String[] words = new String[]{"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";
        System.out.println(problem890.findAndReplacePattern(words, pattern));
    }
}
