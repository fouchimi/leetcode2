import java.util.*;

public class Dijkstra {
    static class Pair implements Comparable<Pair> {
        int v, cost;
        public Pair(int _v, int _cost) {
            this.v = _v;
            this.cost = _cost;
        }

        @Override
        public int compareTo(Pair other) {
            if(this.cost < other.cost) return -1;
            else if(this.cost > other.cost) return 1;
            else return 0;
        }
    }
    private static int distance(ArrayList<Integer>[] adj, ArrayList<Integer>[] cost, int s, int t) {
        int V = adj.length;
        int[] dist = new int[V];
        for(int v = 0; v < V; v++) dist[v] = Integer.MAX_VALUE;

        Map<Integer, List<Pair>> map = new HashMap<>();
        for(int v = 0; v < V; v++) map.put(v, new ArrayList<>());

        for(int v = 0; v < V; v++) {
            for(int u : adj[v]) {
                int cst = cost[v].remove(0);
                map.get(v).add(new Pair(u, cst));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(V, (first, second) -> {
            if(first.cost < second.cost) return -1;
            else if(first.cost > second.cost) return 1;
            else return 0;
        });

        Set<Integer> settled = new HashSet<>();
        pq.offer(new Pair(s, 0));
        dist[s] = 0;

        while (!pq.isEmpty() && settled.size() != V) {
            int u = pq.remove().v;
            settled.add(u);
            exploreNeighbors(u, map, settled, dist, pq);
        }

        return dist[t] == Integer.MAX_VALUE ? -1 : dist[t];
    }

    private static void exploreNeighbors(int u, Map<Integer, List<Pair>> map,  Set<Integer> vertices, int[] dist,  PriorityQueue<Pair> pq){
        for(Pair pair : map.get(u)) {
            int w = pair.v;
            if (!vertices.contains(w)) {
                if(dist[w] > dist[u] + pair.cost) {
                    dist[w] = dist[u] + pair.cost;
                    pq.offer(new Pair(w, dist[w]));
                }
            }
        }
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
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(distance(adj, cost, x, y));
    }
}

