public class Problem96 {
    public int numTrees(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Problem96 problem96 = new Problem96();
        System.out.println(problem96.numTrees(3));
        System.out.println(problem96.numTrees(4));
    }
}
