
public class Problem733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null) return null;
        boolean[][] visited = new boolean[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                if (i == sr && j == sc) {
                    dfs(image, i, j, newColor, image[i][j], visited);
                }
            }
        }
        return image;
    }

    private boolean isSafe(int[][] grid, int row, int col, boolean[][] visited, int oldColor) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length || visited[row][col] || grid[row][col] != oldColor) return false;
        return true;
    }

    private void dfs(int[][] grid, int row, int col, int newColor, int oldColor,  boolean[][] visited) {
        if(isSafe(grid, row, col, visited, oldColor)) {
            if(grid[row][col] == oldColor) grid[row][col] = newColor;
            visited[row][col] = true;
            dfs(grid, row, col+1, newColor, oldColor, visited);
            dfs(grid, row+1, col, newColor, oldColor, visited);
            dfs(grid, row, col-1, newColor,  oldColor,  visited);
            dfs(grid, row-1, col, newColor,  oldColor,  visited);
        }
    }

    public static void main(String[] args) {
        Problem733 problem733 = new Problem733();
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        int[][] result = problem733.floodFill(image, 1, 1, 2);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
