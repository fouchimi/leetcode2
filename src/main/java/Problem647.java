public class Problem647 {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int N = s.length(), k = 0, count = 0;
        if (N == 1) return 1;
        int[][] dp = new int[N][N];
        while (k < 2) {
            for (int i = 0; i < dp.length; ) {
                int j = k;
                for (; j < dp.length; ) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 1;
                        count += 1;
                    }
                    i++;
                    j++;
                }
                if (j == dp.length) break;
            }
            k++;
        }

        while (k < N) {
            for(int i = 0; i < dp.length; ) {
                int j = k;
                for (; j < dp.length; ) {
                    if (s.charAt(i) == s.charAt(j)) {
                        if (i + 1 < dp.length && dp[i + 1][j - 1] == 1) {
                            dp[i][j] = 1;
                            count += 1;
                        }
                    }
                    i++;
                    j++;
                }
                if (j == dp.length) break;
            }
            k++;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem647 problem647 = new Problem647();
        System.out.println(problem647.countSubstrings("abc"));
        System.out.println(problem647.countSubstrings("aaa"));
    }
}
