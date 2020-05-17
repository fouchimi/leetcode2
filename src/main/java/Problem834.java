import java.util.Arrays;

public class Problem834 {

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        for (int i = 0, j = 0; i < N && j < N; i++, j++) dp[i][j] = 0;

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            dp[src][dest] = 1;
            dp[dest][src] = 1;
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) sum += dp[i][j];
            res[i] = sum;
        }

        return res;
    }

    public static void main(String[] args) {
        Problem834 problem834 = new Problem834();
        int[] res = problem834.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
