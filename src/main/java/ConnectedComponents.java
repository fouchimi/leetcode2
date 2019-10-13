import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {
    private static int numberOfComponents(ArrayList<Integer>[] adj) {
        int result = 0, V = adj.length;
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++) {
            if(!visited[v]) {
                dfs(v, visited, adj);
                result++;
            }
        }
        return result;
    }

    private static void dfs(int v, boolean[] visited, ArrayList<Integer>[] adj) {
        visited[v] = true;
        for(int u : adj[v]) {
            if(!visited[u]) dfs(u, visited, adj);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
            adj[y - 1].add(x - 1);
        }
        System.out.println(numberOfComponents(adj));
    }
}

