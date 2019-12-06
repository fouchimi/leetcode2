public class Problem70 {

    public int climbStairs(int n) {
        if (n == 0) return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Problem70 problem70 = new Problem70();
        System.out.println(problem70.climbStairs(1));
        System.out.println(problem70.climbStairs(2));
        System.out.println(problem70.climbStairs(3));
    }
}
