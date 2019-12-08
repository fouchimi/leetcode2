public class Problem516 {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            dp[i][i + 1] = (s.charAt(i) == s.charAt(i + 1) ? 2 : 1);
        }
        for (int len = 3; len <= s.length(); len++) {
            for (int l = 0, r = len - 1; r < s.length(); l++, r++) {
                if (s.charAt(l) == s.charAt(r))
                    dp[l][r] = dp[l + 1][r - 1] + 2;
                else
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        Problem516 problem516 = new Problem516();
        System.out.println(problem516.longestPalindromeSubseq("bbbab"));
        System.out.println(problem516.longestPalindromeSubseq("cbbd"));
        System.out.println(problem516.longestPalindromeSubseq("aabaa"));
    }
}
