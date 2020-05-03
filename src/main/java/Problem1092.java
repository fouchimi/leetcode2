public class Problem1092 {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) dp[i][j] = 0;
                else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        int i = m, j = n;
        StringBuilder sb = new StringBuilder();
        while (i > 0 && j > 0) {
           if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
               sb.insert(0, str1.charAt(i - 1));
               i--;
               j--;
           } else if (dp[i][j - 1] >= dp[i - 1][j]) {
               sb.insert(0, str2.charAt(j - 1));
               j--;
           } else {
               sb.insert(0, str1.charAt(i - 1));
               i--;
           }
        }

        while (i > 0) {
            sb.insert(0, str1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            sb.insert(0, str2.charAt(j - 1));
            j--;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1092 problem1092 = new Problem1092();
        System.out.println(problem1092.shortestCommonSupersequence("abac", "cab"));
    }
}
