import java.util.LinkedList;
import java.util.Queue;

public class Problem1091 {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        if(grid[0][0] == 1) return -1;
        int rows = grid.length, cols = grid[0].length;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        int d = 0;
        while (!q.isEmpty()) {
            int level = q.size();
            int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {-1, -1}, {-1, 1}, {1, -1}};
            for (int i = 0; i < level; i++) {
                int[] pos = q.poll();
                if (pos == null) break;
                if (pos[0] == rows-1 && pos[1] == cols-1) return d+1;
                for (int[] dir : dirs) {
                    int x = pos[0] + dir[0];
                    int y = pos[1] + dir[1];
                    if (isSafe(grid, x, y, visited)) {
                        q.offer(new int[]{x, y});
                        visited[x][y] = true;
                    }
                }
            }
            d++;
        }
        return -1;
    }

    private boolean isSafe(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length  || visited[row][col]) return false;
        return grid[row][col] == 0;
    }

    public static void main(String[] args) {
        Problem1091 problem1091 = new Problem1091();
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(problem1091.shortestPathBinaryMatrix(grid));
    }
}
