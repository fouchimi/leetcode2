import java.util.HashMap;
import java.util.Map;

public class Problem169 {
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
            if (map.get(key) > mid) return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem169 problem169 = new Problem169();
        System.out.println(problem169.majorityElement(new int[] {3, 2, 3}));
        System.out.println(problem169.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
