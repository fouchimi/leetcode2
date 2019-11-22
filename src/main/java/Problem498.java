public class Problem498 {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int rows = matrix.length, cols = matrix[0].length, N = 0;
        int size = rows * cols, i = 0, j = 0;
        int[] res = new int[size];
        while ( N < size) {
            for (; i >= 0 && j < cols; i--, j++) {
                res[N] = matrix[i][j];
                N++;
            }
            i++;
            if (j == cols) {
                j--;
                i++;
            }
            for (; i < rows && j >= 0; i++, j--) {
                res[N] = matrix[i][j];
                N++;
            }
            j++;
            if (i == rows) {
                i--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem498 problem498 = new Problem498();
        int[][] matrix = {{1, 2}, {4, 5}};
        int[] res = problem498.findDiagonalOrder(matrix);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }
}
