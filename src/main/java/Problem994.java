import java.util.LinkedList;
import java.util.Queue;

public class Problem994 {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        int rows = grid.length, cols = grid[0].length, min;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2) {
                  queue.offer(new int[]{i, j});
                }
            }
        }

        min = bfs(queue, grid);

        for (int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) return -1;
            }
        }
        return Math.max(min, 0);
    }

    private int bfs(Queue<int[]> q, int[][] grid) {
        int level = -1;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!q.isEmpty()) {
            int steps = q.size();
            for(int i = 0; i < steps; i++) {
                int[] pos = q.poll();
                if(pos == null) break;
                for(int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if(isValid(grid, x, y)) {
                        grid[x][y] = 2;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return level;
    }

    private boolean isValid(int[][] grid, int row, int col) {
        if(row < 0 || col < 0 || row == grid.length || col == grid[0].length) return false;
        return grid[row][col] == 1;
    }

    public static void main(String[] args) {
        Problem994 problem994 = new Problem994();
        int[][] grid = {{0}};
        System.out.println(problem994.orangesRotting(grid));
    }
}
