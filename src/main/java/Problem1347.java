import java.util.HashMap;
import java.util.Map;

public class Problem1347 {
    public int minSteps(String s, String t) {
        Map<Character, Integer> mapS = new HashMap<>();
        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sKey = s.charAt(i);
            char tKey = t.charAt(i);
            mapS.put(sKey, mapS.getOrDefault(sKey, 0) + 1);
            mapT.put(tKey, mapT.getOrDefault(tKey, 0) + 1);
        }

        int minSteps = 0;
        for (char key : mapS.keySet()) {
            if (!mapT.containsKey(key)) minSteps += mapS.get(key);
            else if (mapT.get(key) < mapS.get(key)) minSteps += mapS.get(key) - mapT.get(key);
        }
        return minSteps;
    }

    public static void main(String[] args) {
        Problem1347 problem1347 = new Problem1347();
        System.out.println(problem1347.minSteps("bab", "aba"));
        System.out.println(problem1347.minSteps("leetcode", "practice"));
        System.out.println(problem1347.minSteps("anagram", "mangaar"));
        System.out.println(problem1347.minSteps("xxyyzz", "xxyyzz"));
        System.out.println(problem1347.minSteps("friend", "family"));
    }
}
