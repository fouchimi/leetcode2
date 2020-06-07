public class Problem718 {
//    public int findLength(int[] A, int[] B) {
//        int windowEnd = 0, max = Integer.MIN_VALUE;
//        for (; windowEnd < A.length; windowEnd++) {
//            for (int windowStart = 0; windowStart < B.length;) {
//                int start = windowStart;
//                while (start < B.length && B[start] != A[windowEnd]) start++;
//                int end = start, tempEnd = windowEnd;
//                while (end < B.length && tempEnd < A.length && B[end] == A[tempEnd]) {
//                    end++;
//                    tempEnd++;
//                }
//                max = Math.max(max, end - start);
//                windowStart = start + 1;
//            }
//        }
//        return max == Integer.MIN_VALUE ? 0 : max;
//    }

    public int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int[][] dp = new int[m + 1][n + 1];
        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A[i - 1] == B[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Problem718 problem718 = new Problem718();
        System.out.println(problem718.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }
}
