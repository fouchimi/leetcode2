import java.util.LinkedHashMap;
import java.util.Map;

public class Problem383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> ransomNoteMap = new LinkedHashMap<>();
        Map<Character, Integer> magazineMap = new LinkedHashMap<>();
        for (int i = 0; i < ransomNote.length(); i++) {
            char key = ransomNote.charAt(i);
            ransomNoteMap.put(key, ransomNoteMap.getOrDefault(key, 0) + 1);
        }
        for (int j = 0; j < magazine.length(); j++) {
            char key = magazine.charAt(j);
            magazineMap.put(key, magazineMap.getOrDefault(key, 0) + 1);
        }

        for (char key : ransomNoteMap.keySet()) {
            if (!magazineMap.containsKey(key) || (magazineMap.containsKey(key) && magazineMap.get(key) < ransomNoteMap.get(key))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem383 problem383 = new Problem383();
        System.out.println(problem383.canConstruct("a", "b"));
        System.out.println(problem383.canConstruct("aa", "ab"));
        System.out.println(problem383.canConstruct("aa", "aab"));
    }
}
