import java.util.Arrays;

public class Problem646 {
    public int findLongestChain(int[][] pairs) {
        if (pairs == null || pairs.length == 0) return 0;
        int length = pairs.length, maxLength = 1;
        Arrays.sort(pairs, (first, second) -> {
            if (first[0] < second[0]) return -1;
            else if (first[0] == second[0]) {
                if (first[1] < second[1]) return -1;
                else if (first[1] == second[1]) return 0;
                else return 1;
            } else return 1;
        });
        int[] dp = new int[length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    maxLength = Math.max(maxLength, dp[i]);
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Problem646 problem646 = new Problem646();
        System.out.println(problem646.findLongestChain(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        System.out.println(problem646.findLongestChain(new int[][]{{3, 4}, {2, 3}, {1, 2}}));
    }
}
