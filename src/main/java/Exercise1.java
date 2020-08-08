public class Exercise1 {
    private int numWays = 0;
    public int numPaths(int M, int N) {
        int[][] grid = new int[M][N];
        int[][] dp = new int[M + 1][N + 1];

        boolean[][] visited = new boolean[M][N];
        dfs(grid, visited, 0, 0);
        return numWays;
    }

    private void dfs(int[][] grid, boolean[][] visited, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]) return;
        if (row == grid.length - 1 && col == grid[0].length - 1)  {
            numWays++;
            return;
        }
        visited[row][col] = true;
        dfs(grid, visited, row, col + 1);
        dfs(grid, visited, row + 1, col);
        visited[row][col] = false;
    }

    public static void main(String[] args) {
        Exercise1 exercise1 = new Exercise1();
        System.out.println(exercise1.numPaths(2, 2));
    }
}
