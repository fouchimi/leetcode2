import java.util.ArrayList;
import java.util.List;

public class Problem1267 {

    public int countServers(int[][] grid) {
        int N = grid.length, M = grid[0].length;
        int size = Math.max(N, M);
        List<Integer>[] list = new ArrayList[size];

        for (int i = 0; i < size; i++) list[i] = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (grid[row][col] == 1) {
                    list[row].add(col);
                    list[col].add(row);
                }
            }
        }

        boolean[] visited = new boolean[size];
        int[] count = new int[1];

        for (int v = 0; v < size; v++) {
            if (!visited[v] && !list[v].isEmpty()) {
                dfs(v, visited, list, count);
            }
        }

        return 0;
    }

    private void dfs(int s, boolean[] visited, List<Integer>[] list, int[] count) {
        if (!visited[s]) count[0]++;
        visited[s] = true;
        for (int w : list[s]) {
            if (!visited[w]) {
                dfs(w, visited, list, count);
            }
        }
    }

}
