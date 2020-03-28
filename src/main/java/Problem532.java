import java.util.HashMap;
import java.util.Map;

public class Problem532 {
    public int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i : nums) {
            if (map.containsKey(i)) {
                if (k == 0 && map.get(i) == 1) {
                    map.put(i, map.get(i) + 1);
                    res++;
                }
                continue;
            }
            res += map.getOrDefault(i + k, 0);
            res += map.getOrDefault(i - k, 0);
            map.put(i, 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem532 problem532 = new Problem532();
        //System.out.println(problem532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(problem532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
        System.out.println(problem532.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
    }
}
