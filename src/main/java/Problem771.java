import java.util.HashMap;
import java.util.Map;

public class Problem771 {
    public int numJewelsInStones(String J, String S) {
        if (J == null || S == null) return 0;
        Map<Character, Integer> map = new HashMap<>();
        char[] strs = S.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            char ch = strs[i];
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        for (int j = 0; j < J.length(); j++) {
            char ch = J.charAt(j);
            if (map.containsKey(ch)) sum += map.get(ch);
        }
        return sum;
    }
}
