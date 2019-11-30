public class Problem63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0][0] == 1) return 0;
        int rows = obstacleGrid.length, cols = obstacleGrid[0].length;
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (obstacleGrid[i][0] == 1) break;
            result[i][0] = 1;
        }

        for (int j = 0; j < cols; j++) {
            if (obstacleGrid[0][j] == 1) break;
            result[0][j] = 1;
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = 0;
                } else {
                    if (result[i-1][j] == 0 || result[i][j-1] == 0) {
                        result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
                    } else {
                        result[i][j] = result[i-1][j] + result[i][j-1];
                    }
                }
            }
        }
        return result[rows-1][cols-1];
    }

    public static void main(String[] args) {
        Problem63 problem63 = new Problem63();
        int[][] obstacleGrid = {{0, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}, {0, 0, 1, 0}, {0, 0, 0, 0}};
        System.out.println(problem63.uniquePathsWithObstacles(obstacleGrid));
    }
}
