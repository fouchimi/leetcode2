public class Problem867 {
    public int[][] transpose(int[][] A) {
        int[][] res = new int[A.length][A[0].length];
        int j = 0;
        for(int[] row : A) {
            int k = 0;
            for (int value : row) {
                res[k][j] = value;
                k++;
            }
            j++;
        }
        return null;
    }
}
