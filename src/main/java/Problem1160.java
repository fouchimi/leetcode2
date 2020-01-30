import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1160 {
    public int countCharacters(String[] words, String chars) {
        int sum = 0;
        Map<Character, Integer> charsMap = buildMap(chars);
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int count = 0;
            Map<Character, Integer> currentMap = buildMap(word);
            for (char key : currentMap.keySet()) {
                int value = currentMap.get(key);
                if (!charsMap.containsKey(key)) break;
                if (charsMap.get(key) >= value) count++;
            }
            if (count == currentMap.size()) sum += word.length();
        }
        return sum;
    }

    private Map<Character, Integer> buildMap(String word) {
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char key = word.charAt(i);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Problem1160 problem1160 = new Problem1160();
        System.out.println(problem1160.countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(problem1160.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
