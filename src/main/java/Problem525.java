import java.util.HashMap;
import java.util.Map;

public class Problem525 {

    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLength = 0, total = 0;
        for (int index = 0; index < nums.length; index++) {
            total = total + (nums[index] == 0 ? -1 : 1);
            if (map.containsKey(total)) {
                maxLength = Math.max(maxLength, index - map.get(total));
            } else {
                map.put(total, index);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem525 problem525 = new Problem525();
        System.out.println(problem525.findMaxLength(new int[]{0, 1}));
        System.out.println(problem525.findMaxLength(new int[]{0, 1, 0}));
    }
}
