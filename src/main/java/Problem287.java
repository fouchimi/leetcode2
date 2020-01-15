import java.util.HashMap;
import java.util.Map;

public class Problem287 {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) return nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem287 problem287 = new Problem287();
        System.out.println(problem287.findDuplicate(new int[]{1,3,4,2,2}));
        System.out.println(problem287.findDuplicate(new int[]{3,1,3,4,2}));
        System.out.println(problem287.findDuplicate(new int[]{4,3,1,4,2}));
    }
}
