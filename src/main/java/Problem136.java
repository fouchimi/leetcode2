import java.util.HashMap;
import java.util.Map;

public class Problem136 {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem136 problem136 = new Problem136();
        int[] nums = {2,2,1};
        System.out.println(problem136.singleNumber(nums));
    }
}
