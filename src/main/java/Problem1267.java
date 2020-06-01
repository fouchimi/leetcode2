import java.util.ArrayList;
import java.util.List;

public class Problem1267 {

    public int countServers(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int size = Math.max(N, M);
        List<Integer>[] map = new ArrayList[size];

        for (int i = 0; i < size; i++) map[i] = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (grid[row][col] == 1) map[row].add(col);
            }
        }

        for (int col = 0; col < M; col++) {
            for (int row = 0; row < N; row++) {
                if (grid[row][col] == 1) {
                   if (!map[col].contains(row)) map[col].add(row);
                }
            }
        }

        boolean[][] visited = new boolean[N][M];
        int ans = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (!visited[row][col] && grid[row][col] == 1) {

                }
            }
        }

        return ans;
    }

    private void dfs(int u, int v,  List<Integer>[] map, boolean[][] visited, int[] count) {
        count[0]++;
        for (int w : map[u]) {

            if (!visited[u][w]) {
                dfs(u, w, map, visited, count);
            }
        }
    }

    public static void main(String[] args) {
        Problem1267 problem1267 = new Problem1267();
        System.out.println(problem1267.countServers(new int[][]{{1, 0}, {0, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 0}, {1, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}}));
        System.out.println(problem1267.countServers(new int[][]{{1, 0, 0, 1, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
    }


}
