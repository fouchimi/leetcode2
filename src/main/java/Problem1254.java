public class Problem1254 {
    public int closedIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if ((i == 0 || i == rows - 1 || j == 0 || j == cols - 1) && grid[i][j] == 0 && !visited[i][j]) {
                    dfs (grid, i, j, visited);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 1 || visited[row][col]) return;
        visited[row][col] = true;
        dfs(grid, row, col+1, visited);
        dfs(grid, row+1, col, visited);
        dfs(grid, row, col-1, visited);
        dfs(grid, row-1, col, visited);
    }

    public static void main(String[] args) {
        Problem1254 problem1254 = new Problem1254();
        int[][] grid = {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}};
        System.out.println(problem1254.closedIsland(grid));
    }
}
