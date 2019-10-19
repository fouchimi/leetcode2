import java.util.*;

public class Djikstra {
    class Pair implements Comparable<Pair> {
        int v;
        int cost;

        public Pair(int _v, int _cost) {
            this.v = _v;
            this.cost = _cost;
        }

        @Override
        public int compareTo(Pair second) {
            if (this.cost < second.cost) return -1;
            else if (this.cost > second.cost) return 1;
            return 0;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        Map<Integer, List<Pair>> map = new HashMap<>();
        for(int v = 0; v < n; v++) map.put(v, new ArrayList<>());

        for(int v = 0; v < flights.length; v++) {
            int[] tuple = flights[v];
            map.get(tuple[0]).add(new Pair(tuple[1], tuple[2]));
        }
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Pair> pq = new PriorityQueue<>(n, (first, second) -> {
            if (first.cost < second.cost) return -1;
            else if(first.cost > second.cost) return 1;
            return 0;
        });
        Set<Integer> vertices = new HashSet<>();

        dist[src] = 0;
        pq.offer(new Pair(src, 0));
        while(vertices.size() != n) {
            int v = pq.remove().v;
            if(v == dst) return dist[dst];
            if(K < -1) return -1;
            vertices.add(v);
            exploreNeighbors(v, map, vertices, dist, pq);
            K--;
        }

        return -1;
    }

    private void exploreNeighbors(int u, Map<Integer, List<Pair>> map, Set<Integer> vertices, int[] dist, PriorityQueue<Pair> pq) {
        for(Pair pair : map.get(u)) {
            int w = pair.v;

            if(!vertices.contains(w)) {
                int newDistance = dist[u] + pair.cost;
                if (newDistance < dist[w]) dist[w] = newDistance;
                pq.offer(new Pair(w, dist[w]));
            }
        }
    }
}
