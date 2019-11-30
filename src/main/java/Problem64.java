public class Problem64 {

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        int[][] board = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (i == 0) board[i][0] = grid[i][0];
            else board[i][0] = board[i-1][0] + grid[i][0];
        }
        for (int j = 0; j < cols; j++) {
            if (j == 0) board[0][j] = grid[0][j];
            else board[0][j] = board[0][j-1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                board[i][j] = Math.min(board[i-1][j], board[i][j-1]) + grid[i][j];
            }
        }

        return board[rows-1][cols-1];
    }

    public static void main(String[] args) {
        Problem64 problem64 = new Problem64();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(problem64.minPathSum(grid));
    }
}
