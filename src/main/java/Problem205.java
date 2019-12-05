import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Problem205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null) return true;
        else if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> map = new LinkedHashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char sKey = s.charAt(i);
            char tKey = t.charAt(i);
            if ((map.containsKey(sKey) && map.get(sKey) != tKey) || (!map.containsKey(sKey) && !used.add(tKey))) return false;
            map.put(sKey, tKey);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem205 problem205 = new Problem205();
        System.out.println(problem205.isIsomorphic("egg", "add"));
        System.out.println(problem205.isIsomorphic("foo", "bar"));
        System.out.println(problem205.isIsomorphic("paper", "title"));
        System.out.println(problem205.isIsomorphic("abba", "abab"));
        System.out.println(problem205.isIsomorphic("ab", "aa"));
    }
}
