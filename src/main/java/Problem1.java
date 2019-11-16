import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[]{0};
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1 problem1 = new Problem1();
        int[] nums = {2, 7, 11, 15};
        int[] res = problem1.twoSum(nums, 9);
        for(int index : res) {
            System.out.print(index + " ");
        }
    }
}
