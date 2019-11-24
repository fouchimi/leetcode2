import java.util.HashMap;
import java.util.Map;

public class Problem3 {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0, j = 0;
        Map<Character, Integer> map= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) j = Math.max(j, map.get(ch));
            ans = Math.max(i - j + 1, ans);
            map.put(ch, i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem3 problem3 = new Problem3();
        System.out.println(problem3.lengthOfLongestSubstring("abcabcbb"));
    }
}
