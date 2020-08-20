import java.util.*;

public class Problem659 {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int num : nums) {
            if (map.get(num) == 0) continue;
            int freq = map.get(num), count = 0, curr = num;
            while (map.containsKey(curr) && map.get(curr) >= freq) {
                freq = Math.max(freq, map.get(curr));
                map.put(curr, map.get(curr) - 1);
                curr++;
                count++;
            }
            if (count < 3) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem659 problem659 = new Problem659();
        System.out.println(problem659.isPossible(new int[]{1, 2, 3, 3, 4, 5}));
        System.out.println(problem659.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
        System.out.println(problem659.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
    }
}
