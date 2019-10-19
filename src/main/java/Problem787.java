import java.util.*;

public class Problem787 {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        int[] dist = new int[n];
        for(int v = 0; v < n; v++) dist[v] = Integer.MAX_VALUE;
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int v = 0; v < n; v++) map.put(v, new ArrayList<>());

        for(int i = 0; i < flights.length; i++) {
            int[] tuple = flights[i];
            map.get(tuple[0]).add(new int[]{tuple[1], tuple[2]});
        }
        List<Integer> path = new ArrayList<>();
        path.add(src);
        Queue<List<Integer>> q = new ArrayDeque<>();
        q.offer(path);
        dist[src] = 0;
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            List<Integer> currentPath = q.poll();
            int u = currentPath.get(currentPath.size()-1);
            if(!visited.contains(u)) {
                for(int[] neighborTuple : map.get(u)) {
                    int w = neighborTuple[0];
                    List<Integer> newPath = new ArrayList<>(currentPath);
                    newPath.add(w);
                    q.offer(newPath);
                    if (dist[w] > dist[u] + neighborTuple[1]) {
                        if (newPath.size() - 2 < K || (w == dst && newPath.size() - 2 == K))
                            dist[w] = dist[u] + neighborTuple[1];
                    }
                }
                visited.add(u);
            }
        }
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }


    public static void main(String[] args){
        Problem787 problem787 = new Problem787();
        int n = 3;
//        int[][] flights = {{0,1,5},{1,2,5},{0,3,2},{3,1,2},{1,4,1},{4,2,1}};
        int[][] flights = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};

        System.out.println(problem787.findCheapestPrice(n, flights, 0, 2, 0));
    }


}
