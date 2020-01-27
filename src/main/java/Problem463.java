public class Problem463 {
    public int islandPerimeter(int[][] grid) {
        int perimeter = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // check top
                    if (i - 1 < 0 || grid[i-1][j] == 0) perimeter++;
                    // check left
                    if (j - 1 < 0 || grid[i][j-1] == 0) perimeter++;
                    // check bottom
                    if (i + 1 == grid.length || grid[i + 1][j] == 0) perimeter++;
                    // check right
                    if (j + 1 == grid[0].length || grid[i][j + 1] == 0) perimeter++;
                }
            }

        }
        return perimeter;
    }

    public static void main(String[] args) {
        Problem463 problem463 = new Problem463();
        int[][] grid = new int[][]{{0, 1, 0, 0}, {1, 1, 1, 0}, {0, 1, 0, 0}, {1, 1, 0, 0}};
        System.out.println(problem463.islandPerimeter(grid));
    }
}
