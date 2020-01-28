import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem299 {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char ch = secret.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int bull = 0, cow = 0;
        Set<Integer> used = new HashSet<>();
        for (int j = 0; j < guess.length(); j++) {
            char ch = guess.charAt(j);
            if (ch == secret.charAt(j)) {
                bull++;
                map.put(ch, map.get(ch) - 1);
                used.add(j);
            }
        }
        for (int k = 0; k < guess.length(); k++) {
            char ch = guess.charAt(k);
            if (map.containsKey(ch) && map.get(ch) > 0 && !used.contains(k)) {
                map.put(ch, map.get(ch) - 1);
                cow++;
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args) {
        Problem299 problem299 = new Problem299();
        System.out.println(problem299.getHint("1807", "7810"));
        System.out.println(problem299.getHint("1123", "0111"));
        System.out.println(problem299.getHint("11", "10"));
    }
}
