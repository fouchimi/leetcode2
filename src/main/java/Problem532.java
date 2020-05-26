import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem532 {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        int last = Integer.MIN_VALUE, i = 0;
        while(i < nums.length) {
            while (last > Integer.MIN_VALUE && i < nums.length && nums[i] == last) i++;
            if (i == nums.length) break;
            int prev = Integer.MIN_VALUE, j = i+1;
            while (j < nums.length) {
                if (prev > Integer.MIN_VALUE && j < nums.length && nums[j] == prev) j++;
                else {
                    if (nums[j] - nums[i] == k) count++;
                    prev = nums[j];
                    j++;
                }
            }
            last = nums[i];
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem532 problem532 = new Problem532();
//        System.out.println(problem532.findPairs(new int[]{3, 1, 4, 1, 5}, 2));
//        System.out.println(problem532.findPairs(new int[]{1, 3, 1, 5, 4}, 0));
//        System.out.println(problem532.findPairs(new int[]{1, 2, 3, 4, 5}, -1));
//        System.out.println(problem532.findPairs(new int[]{1, 2, 3, 4, 5}, 1));
        //System.out.println(problem532.findPairs(new int[]{1, 1, 1, 1, 1}, 0));
        System.out.println(problem532.findPairs(new int[]{-1, 0, 0, 1, 0, 0, -1}, 1));
    }
}
