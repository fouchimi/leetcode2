public class Problem1035 {

    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null) return 0;

        int[][] DP = new int[A.length + 1][B.length + 1];

        for (int i = 1; i <= A.length; i++){
            for (int j = 1; j <= B.length; j++){
                DP[i][j] = (A[i - 1] == B[j - 1]) ? 1 + DP[i - 1][j - 1] : Math.max(DP[i - 1][j], DP[i][j - 1]);
            }
        }

        return DP[A.length][B.length];
    }

    public static void main(String[] args) {
        Problem1035 problem1035 = new Problem1035();
        System.out.println(problem1035.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(problem1035.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(problem1035.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
