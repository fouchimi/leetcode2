import java.util.HashMap;
import java.util.Map;

public class Problem1189 {
    public int maxNumberOfBalloons(String text) {
        char[] balloon = {'b', 'a', 'l', 'l', 'o', 'o', 'n'};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int i = 0, count = 0;
        while (map.containsKey(balloon[i]) && map.get(balloon[i]) > 0) {
            map.put(balloon[i], map.get(balloon[i]) - 1);
            i = (i + 1) % balloon.length;
            if (i == 0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1189 problem1189 = new Problem1189();
        System.out.println(problem1189.maxNumberOfBalloons("nlaebolko"));
        System.out.println(problem1189.maxNumberOfBalloons("loonbalxballpoon"));
        System.out.println(problem1189.maxNumberOfBalloons("leetcode"));
    }
}
