import java.util.Arrays;

public class Problem354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;
        int length = envelopes.length, maxCount = 1;
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        Arrays.sort(envelopes, (first, second) -> first[0] != second[0] ? Integer.compare(first[0], second[0]) : Integer.compare(first[1], second[1]));

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxCount = Math.max(dp[i], maxCount);
                }
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        Problem354 problem354 = new Problem354();
        System.out.println(problem354.maxEnvelopes(new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}}));
        System.out.println(problem354.maxEnvelopes(new int[][]{{30 ,50}, {12, 2}, {3 ,4}, {12, 15}}));
        System.out.println(problem354.maxEnvelopes(new int[][]{{1, 2},{2, 3},{3, 4},{4, 5},{5, 6},{5, 5},{6, 7},{7, 8}}));
        System.out.println(problem354.maxEnvelopes(new int[][] {{2, 100},{3, 200},{4, 300},{5, 500},{5, 400},{5, 250},{6, 370},{6, 360},{7, 380}}));
        System.out.println(problem354.maxEnvelopes(new int[][]{{10, 17}, {10, 19}, {16, 2}, {19, 18}, {5, 6}}));
    }
}
