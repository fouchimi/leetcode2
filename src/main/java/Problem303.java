public class Problem303 {
    private int[] dp;
    public Problem303(int[] nums) {
        int N = nums.length;
        dp = new int[N];
        for (int i = 0; i < N; i++) dp[i] = nums[i];
        for (int i = 1; i < N; i++) dp[i] += dp[i - 1];
    }

    public int sumRange(int i, int j) {
        return i == 0 ? this.dp[j] : dp[j] - dp[i - 1];
    }

    public static void main(String[] args) {
        Problem303 problem303 = new Problem303(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(problem303.sumRange(0, 2));
        System.out.println(problem303.sumRange(2, 5));
        System.out.println(problem303.sumRange(0, 5));

    }
}
