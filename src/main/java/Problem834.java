import java.util.*;

public class Problem834 {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N == 1) return new int[N];
        if (N == 2) return new int[]{1, 1};

        List<int[]>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < edges.length; i++) {
            // [0] = to  [1] = sum  [2] = num
            graph[edges[i][0]].add(new int[]{edges[i][1], 0, 0});
            graph[edges[i][1]].add(new int[]{edges[i][0], 0, 0});
        }

        int[] result = new int[N];
        boolean[] seen = new boolean[N];
        for (int i = 0; i < N; i++) result[i] = dfs(graph, i, seen)[0];
        return result;
    }

    private int[] dfs(List<int[]>[] graph, int v, boolean[] seen) {
        seen[v] = true;
        int sum = 0, num = 1;
        for (int[] adj : graph[v]) {
            if (!seen[adj[0]]) {
                if (adj[1] == 0 && adj[2] == 0) {
                    int[] res = dfs(graph, adj[0], seen);
                    adj[1] = res[0];
                    adj[2] = res[1];
                }
                sum += (adj[1] + adj[2]);
                num += adj[2];
            }
        }
        seen[v] = false;
        return new int[]{sum, num};
    }

    public static void main(String[] args) {
        Problem834 problem834 = new Problem834();
        int[] ans = problem834.sumOfDistancesInTree(6, new int[][]{{0,1},{0,2},{2,3},{2,4},{2,5}});
        for (int val : ans) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
