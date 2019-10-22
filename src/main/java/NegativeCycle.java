import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NegativeCycle {
    static class Edge {
        int src, dst, weight;
        public Edge(int _src, int _dst, int _weight) {
            this.src = _src;
            this.dst = _dst;
            this.weight = _weight;
        }
    }
    private static int negativeCycle(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost) {
        List<Edge> edgeList = new ArrayList<>();
        int V = adj.length;
        for(int v = 0; v < V; v++) {
            for(int u : adj[v]) {
                int weight = cost[v].remove(0);
                edgeList.add(new Edge(v, u, weight));
            }
        }

        int[] dist = new int[V];
        for(int i = 1; i < V; i++) {
            for(int j = 0; j < edgeList.size(); j++) {
                int v = edgeList.get(j).src;
                int w = edgeList.get(j).dst;
                int weight = edgeList.get(j).weight;
                if(dist[w] != Integer.MAX_VALUE && dist[w] > dist[v] + weight) {
                    dist[w] = dist[v] + weight;
                }
            }
        }

        for (int j = 0; j < edgeList.size(); ++j) {
            int u = edgeList.get(j).src;
            int v = edgeList.get(j).dst;
            int weight = edgeList.get(j).weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        ArrayList<Integer>[] cost = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
            cost[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y, w;
            x = scanner.nextInt();
            y = scanner.nextInt();
            w = scanner.nextInt();
            adj[x - 1].add(y - 1);
            cost[x - 1].add(w);
        }
        System.out.println(negativeCycle(adj, cost));
    }
}

