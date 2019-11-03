import java.util.*;

public class Problem851 {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int V = quiet.length;

        for (int i = 0; i < V; i++) map.put(i, new HashSet<>());

        for (int i = 0; i < richer.length; i++) {
            int[] tuple = richer[i];
            map.get(tuple[1]).add(tuple[0]);
        }

        int[] ans = new int[V];
        for (int v = 0; v < V; v++) ans[v] = v;

        for (int v = 0; v < V; v++) {
            dfs(v, map, new boolean[V], ans, quiet, v);
        }

        return ans;
    }

    private void dfs(int s, Map<Integer, Set<Integer>> map, boolean[] visited, int[] ans, int[] quiet, int v) {
        visited[s] = true;
        for(int w : map.get(s)) {
            if (!visited[w]) {
                if (quiet[w] < quiet[ans[v]]) {
                    ans[v] = w;
                }
                dfs(w, map, visited, ans, quiet, v);
            }
        }
    }

    public static void main(String[] args) {
        Problem851 problem851 = new Problem851();
        int[][] richer = {{1, 0}, {2, 1}, {3, 1}, {3, 7}, {4, 3}, {5, 3}, {6, 3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        int[] res = problem851.loudAndRich(richer, quiet);
        for (int val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
