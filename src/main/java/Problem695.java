public class Problem695 {
    int count = 0;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int maxAreaCount = 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                count = 0;
                if(!visited[i][j] && grid[i][j] == 1) {
                    dfs(grid, visited, i, j);
                    maxAreaCount = Math.max(maxAreaCount, count);
                }
            }
        }
        return maxAreaCount;
    }

    private boolean isSafe(int[][] grid, boolean[][] visited, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col]) return false;
        return grid[row][col] == 1;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (isSafe(grid, visited, row, col)) {
            count++;
            visited[row][col] = true;
            dfs(grid, visited, row, col+1);
            dfs(grid, visited, row+1, col);
            dfs(grid, visited, row, col-1);
            dfs(grid, visited, row-1, col);
        }
    }

    public static void main(String[] args) {
        Problem695 problem695 = new Problem695();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(problem695.maxAreaOfIsland(grid));
    }
}
