import java.util.ArrayList;
import java.util.List;

public class Problem1319 {

    public int makeConnected(int n, int[][] connections) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();
        for (int[] connection : connections) {
            map[connection[0]].add(connection[1]);
            map[connection[1]].add(connection[0]);
        }
        boolean[] visited = new boolean[n];
        int connectedComponents = 0, unConnectedComponents = 0;
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                if (map[v].size() > 0) {
                    dfs(v, map, visited);
                    connectedComponents++;
                }
                else unConnectedComponents++;
            }
        }

        if (unConnectedComponents == 0) return 0;
        else if (connections.length >= n - 1) return (unConnectedComponents + connectedComponents) - 1;
        else return -1;
    }

    private void dfs(int s, List<Integer>[] map, boolean[] visited) {
        visited[s] = true;
        for(int w : map[s]) {
            if(!visited[w]) {
                dfs(w, map, visited);
            }
        }
    }

    public static void main(String[] args) {
        Problem1319 problem1319 = new Problem1319();
        System.out.println(problem1319.makeConnected(4, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
        System.out.println(problem1319.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2},{1,3}}));
        System.out.println(problem1319.makeConnected(6, new int[][]{{0,1},{0,2},{0,3},{1,2}}));
        System.out.println(problem1319.makeConnected(5, new int[][]{{0,1},{0,2},{3,4},{2,3}}));
    }
}
