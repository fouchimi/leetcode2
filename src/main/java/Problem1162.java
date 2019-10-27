import java.util.LinkedList;
import java.util.Queue;

public class Problem1162 {
    public int maxDistance(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        Queue<int[]> queue = new LinkedList<>();
        int countZeros = 0;

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                   queue.offer(new int[]{i, j});
                   visited[i][j] = true;
                } else countZeros++;
            }
        }

        if (queue.isEmpty() || countZeros == 0) return -1;

        int level = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                if (pos == null) break;
                int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (isSafe(grid, x, y, visited)) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return level;
    }

    private boolean isSafe (int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || visited[row][col]) return false;
        return grid[row][col] == 0;
    }

    public static void main(String[] args) {
        Problem1162 problem1162 = new Problem1162();
        int[][] matrix = {{1,0,0},{0,0,0},{0,0,0}};
        System.out.println(problem1162.maxDistance(matrix));
    }
}
