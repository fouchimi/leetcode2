import java.util.LinkedHashMap;
import java.util.Map;

public class Problem523 {

    /*
       The idea here is to find two numbers that yield to the same modulo against k.
       If you find such numbers make sure their indexes satisfies the constraint
       j - i >= 2. It is important to use LinkedHashMap because it tracks the order of insertion.
    */
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) sum = sum % k;
            if (map.containsKey(sum) && i - map.get(sum) >= 2) return true;
            else if (!map.containsKey(sum)) map.put(sum, i);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem523 problem523 = new Problem523();
//        System.out.println(problem523.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6));
//        System.out.println(problem523.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6));
//        System.out.println(problem523.checkSubarraySum(new int[]{23, 2, 0, 6, 0, 0, 4, 7}, 0));
//        System.out.println(problem523.checkSubarraySum(new int[]{0}, -1));
//        System.out.println(problem523.checkSubarraySum(new int[]{1, 2, 3}, 5));
//        System.out.println(problem523.checkSubarraySum(new int[]{1, 0}, 2));
//        System.out.println(problem523.checkSubarraySum(new int[]{1, 2, 12}, 6));
        System.out.println(problem523.checkSubarraySum(new int[]{0, 0}, 0));
        System.out.println(problem523.checkSubarraySum(new int[]{0}, 0));
    }
}
