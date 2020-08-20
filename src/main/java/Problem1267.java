import java.util.*;

public class Problem1267 {

    public int countServers(int[][] grid) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int res = 0, rows = grid.length, cols = grid[0].length;
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    int node = convert(i, j, cols);
                    getChildren(node, i, j, grid, map);
                }
            }
        }

        for (int key : map.keySet()) {
            if (visited[key]) continue;
            int[] count = new int[1];
            dfs(key, map, count, visited);
            if (count[0] > 1) res += count[0];
        }

        return res;
    }

    private int convert(int row, int col, int N) {
        return N * row + col;
    }

    private void getChildren(int node, int row, int col, int[][] grid, Map<Integer, List<Integer>> map) {
        map.putIfAbsent(node, new ArrayList<>());
        int cols = grid[0].length;
        // Go left
        for (int c = col - 1; c >= 0; c--) {
            if (grid[row][c] == 1) map.get(node).add(convert(row, c, cols));
        }

        // Go right
        for (int c = col + 1; c < grid[0].length; c++) {
            if (grid[row][c] == 1) map.get(node).add(convert(row, c, cols));
        }

        // Go up
        for (int r = row - 1; r >= 0; r--) {
            if (grid[r][col] == 1) map.get(node).add(convert(r, col, cols));
        }

        // Go Down
        for (int r = row + 1; r < grid.length; r++) {
            if (grid[r][col] == 1) map.get(node).add(convert(r, col, cols));
        }
    }

    private void dfs(int s, Map<Integer, List<Integer>> map, int[] count, boolean[] visited) {
        if (visited[s]) return;
        visited[s] = true;
        count[0]++;
        for (int w : map.get(s)) {
            dfs(w, map, count, visited);
        }
    }

    public static void main(String[] args) {
        Problem1267 problem1267 = new Problem1267();
        System.out.println(problem1267.countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(problem1267.countServers(new int[][]{{0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 1}, {0, 0, 1, 1}, {0, 0, 0, 1}}));
    }


}
