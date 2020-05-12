import java.util.Arrays;

public class Problem322 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return -1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Problem322 problem322 = new Problem322();
//        System.out.println(problem322.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(problem322.coinChange(new int[]{2}, 3));
    }
}
