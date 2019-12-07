public class Problem5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int N = s.length(), maxLength = 0, k = 0, cols = 2;
        String maxSubStr = "";
        if (N == 1 || (N == 2 && s.charAt(0) == s.charAt(1))) return s;
        int[][] dp = new int[N][N];
        while (k < 2) {
            for (int i = 0; i < dp.length; ) {
                int j = k;
                for (; j < dp.length && i < dp.length;) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            maxSubStr = s.substring(i, j + 1);
                        }
                    }
                    i++;
                    j++;
                }
                if (j == dp.length) break;
            }
            k++;
        }

        while (cols < N) {
            for (int i = 0; i < dp.length;) {
                int j = cols;
                for (; j < dp.length; j++) {
                    if (s.charAt(i) == s.charAt(j) && (i + 1 < dp.length && dp[i + 1][j - 1] == 1)) {
                        dp[i][j] = 1;
                        if (j - i + 1 > maxLength) {
                            maxLength = j - i + 1;
                            maxSubStr = s.substring(i, j + 1);
                        }
                    }
                    i++;
                }
                cols++;
                if (j == dp.length) break;
            }
        }
        return maxSubStr;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
//        System.out.println(problem5.longestPalindrome("babad"));
//        System.out.println(problem5.longestPalindrome("cbbd"));
        System.out.println(problem5.longestPalindrome("abcba"));
    }
}
