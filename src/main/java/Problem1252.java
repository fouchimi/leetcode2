

public class Problem1252 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] res = new int[n][m];
        for (int[] index : indices) {
            int rowIndex = index[0], colIndex = index[1];
            for (int col = 0; col < m; col++) res[rowIndex][col] += 1;
            for (int row = 0; row < n; row++) res[row][colIndex] += 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (res[i][j] % 2 != 0) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Problem1252 problem1252 = new Problem1252();
        System.out.println(problem1252.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}}));
    }
}
