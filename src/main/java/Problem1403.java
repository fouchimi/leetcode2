import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) sum += num;
        int newSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (newSum > sum) break;
            newSum += nums[i];
            sum -= nums[i];
            res.add(nums[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1403 problem1403 = new Problem1403();
        System.out.println(problem1403.minSubsequence(new int[]{4,3,10,9,8}));
        System.out.println(problem1403.minSubsequence(new int[]{4,4,7,6,7}));
        System.out.println(problem1403.minSubsequence(new int[]{6}));
        System.out.println(problem1403.minSubsequence(new int[]{1,7,4,7,1,9,4,8,8}));
    }
}
