public class Problem494 {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(0, nums, S, 0);
    }

    private int dfs(int currSum, int[] nums, int S, int currentIndex) {
        if (currentIndex == nums.length) {
            return currSum == S ? 1 : 0;
        } else  {
            int left = currSum - nums[currentIndex];
            int right = currSum + nums[currentIndex];
            return dfs(left, nums, S, currentIndex + 1) + dfs(right, nums, S, currentIndex + 1);
        }
    }

    public static void main(String[] args) {
        Problem494 problem494 = new Problem494();
        System.out.println(problem494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
