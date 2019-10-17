import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Bipartite {
    private static int bipartite(ArrayList<Integer>[] adj) {
        int V = adj.length;
        int[] colors = new int[V];
        boolean[] visited = new boolean[V];
        for(int v = 0; v < V; v++) colors[v] = -1;
        for(int v = 0; v < V; v++) {
            if(!visited[v]) {
                if(!bfs(v, adj, visited, colors)) return 0;
            }
        }
        return 1;
    }

    private static boolean bfs(int s, ArrayList<Integer>[] adj, boolean[] visited, int[] colors) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        while (!queue.isEmpty()) {
            int u = queue.poll();
            visited[u] = true;
            for(int w : adj[u]) {
                if(!visited[w] && colors[w] == -1) {
                    colors[w] = 1-colors[u];
                    queue.offer(w);
                } else if (visited[w] && colors[w] == colors[u]) return false;
            }
        }
        return true;
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
        System.out.println(bipartite(adj));
    }
}

