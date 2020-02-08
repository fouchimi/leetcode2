import java.util.LinkedHashMap;
import java.util.Map;

public class Problem594 {
    public int findLHS(int[] nums) {
        int count = 0;
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.containsKey(nums[i] + 1)) {
                count = Math.max(count, map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem594 problem594 = new Problem594();
        System.out.println(problem594.findLHS(new int[]{1,3,2,2,5,2,3,7}));
    }
}
