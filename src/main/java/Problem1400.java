import java.util.*;

public class Problem1400 {

    public boolean canConstruct(String s, int k) {
        if (k > s.length()) return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int oddCount = 0;
        for (char key : map.keySet()) {
            int value = map.get(key);
            if (value % 2 == 1) oddCount++;
        }

        return oddCount <= k;
    }


    public static void main(String[] args) {
        Problem1400 problem1400 = new Problem1400();
        System.out.println(problem1400.canConstruct("annabelle", 2));
        System.out.println(problem1400.canConstruct("leetcode", 3));
        System.out.println(problem1400.canConstruct("true", 4));
        System.out.println(problem1400.canConstruct("yzyzyzyzyzyzyzy", 2));
        System.out.println(problem1400.canConstruct("cr", 7));
    }
}
