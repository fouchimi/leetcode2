public class Problem1034 {

    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
        if (grid[r0][c0] == color) return grid;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        dfs(grid, r0, c0, grid[r0][c0], color, visited);
        return grid;
    }

    private boolean isSafe (int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]) return false;
        return true;
    }

    private boolean dfs(int[][] grid, int row, int col, int oldColor, int color, boolean[][] visited) {
       if (!isSafe(grid, row, col,  visited)) return false;
       if (grid[row][col] != oldColor) return true;
       visited[row][col] = true;
       if (row == 0 || col == 0 || row == grid.length - 1 || col == grid[0].length - 1) grid[row][col] = color;
       boolean ans = dfs(grid, row, col+1, oldColor, color, visited);
       ans |= dfs(grid, row+1, col, oldColor, color, visited);
       ans |= dfs(grid, row, col-1, oldColor, color, visited);
       ans |= dfs(grid, row-1, col, oldColor, color, visited);
       if (ans) grid[row][col] = color;
       return false;
    }

    public static void main(String[] args) {
        Problem1034 problem1034 = new Problem1034();
        int[][] grid = {{1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
        int[][] res;
        res = problem1034.colorBorder(grid, 1, 1, 2);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
