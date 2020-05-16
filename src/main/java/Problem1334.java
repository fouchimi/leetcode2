import java.util.Arrays;

public class Problem1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);

        for (int i = 0, j = 0; i < n && j < n; i++, j++) dp[i][j] = 0;

        for (int[] edge : edges) {
            int src = edge[0], dest = edge[1], dist = edge[2];
            dp[src][dest] = dist;
            dp[dest][src] = dist;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE, selectedCity = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (dp[i][j] <= distanceThreshold) count++;
            }
            if (count < min) {
                selectedCity = i;
                min = count;
            }
        }

        return selectedCity;
    }


    public static void main(String[] args) {
        Problem1334 problem1334 = new Problem1334();
        System.out.println(problem1334.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(problem1334.findTheCity(5, new int[][]{{0, 1, 2},{0, 4, 8},{1, 2, 3},{1, 4, 2},{2, 3, 1},{3, 4, 1}}, 2));
    }
}
