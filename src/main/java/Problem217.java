import java.util.HashMap;
import java.util.Map;

public class Problem217 {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return true;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return false;
    }
}
