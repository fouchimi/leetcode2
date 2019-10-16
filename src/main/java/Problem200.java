public class Problem200 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int nbrOfIslands = 0;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j, visited);
                    nbrOfIslands++;
                }
            }
        }
        return nbrOfIslands;
    }

    private boolean isSafe(char[][] grid, int row, int col, boolean[][] visited) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        return grid[row][col] == '1' && !visited[row][col];
    }

    private void dfs(char[][] grid, int row, int col, boolean[][] visited) {
        if(isSafe(grid, row, col, visited)) {
            visited[row][col] = true;
            dfs(grid, row, col+1, visited);
            dfs(grid, row+1, col, visited);
            dfs(grid, row, col-1, visited);
            dfs(grid, row-1, col, visited);
        }
    }

    public static void main(String[] args) {
        Problem200 problem200 = new Problem200();
        char[][] grid = {{'1', '1', '0', '0', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}};
        System.out.println(problem200.numIslands(grid));
    }
}
