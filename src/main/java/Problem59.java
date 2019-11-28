public class Problem59 {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, right = n-1, bottom = n-1, left = 0, val = 1;
        while(left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) matrix[top][i] = val++;
            top++;
            for (int j = top; j <= bottom; j++) matrix[j][right] = val++;
            right--;
            for (int k = right; k >= left; k--) matrix[bottom][k] = val++;
            bottom--;
            for (int l = bottom; l >= top; l--) matrix[l][left] = val++;
            left++;
        }
        return matrix;
    }

    public static void main(String[] args) {
        Problem59 problem59 = new Problem59();
        int[][] res = problem59.generateMatrix(4);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
