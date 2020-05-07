public class Problem377 {

    public int combinationSum4(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int[] memo = new int[target + 1];
        for (int i = 0; i <= target; i++) memo[i] = Integer.MIN_VALUE;
        memo[0] = 1;
        return helper(nums, target, memo);
    }

    private int helper(int[] nums, int target, int[] memo) {
        if (memo[target] != Integer.MIN_VALUE) return memo[target];
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                ans += helper(nums, target - nums[i], memo);
            }
        }

        return memo[target] = ans;
    }

    public static void main(String[] args) {
        Problem377 problem377 = new Problem377();
        System.out.println(problem377.combinationSum4(new int[]{1, 2, 3}, 4));
    }
}
