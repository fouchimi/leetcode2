import java.util.Arrays;

public class Problem334 {

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int length = nums.length, maxCount = 1;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxCount = Math.max(maxCount, dp[i]);
            if (maxCount == 3) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem334 problem334 = new Problem334();
        System.out.println(problem334.increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        System.out.println(problem334.increasingTriplet(new int[]{5, 4, 3, 2, 1}));
    }
}
