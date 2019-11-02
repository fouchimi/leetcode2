import java.util.*;

public class Problem1245 {

    public int treeDiameter(int[][] edges) {
        int V = edges.length + 1;
        Map<Integer, List<Integer>> map =new HashMap<>();
        for (int v = 0; v < V; v++) map.put(v, new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int[] pair = edges[i];
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
        }
        int dst = bfs(0, map, V, true);
        return bfs(dst, map, V, false);
    }

    private int bfs(int s, Map<Integer, List<Integer>> map, int V, boolean flag) {
        boolean[] visited = new boolean[V];
        Queue<Integer>  q = new LinkedList<>();
        q.offer(s);
        int deepestNode = -1, level = -1;
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (q.isEmpty()) break;
                int v = q.poll();
                visited[v] = true;
                deepestNode = v;
                for (int w : map.get(v)) {
                    if (!visited[w]) q.offer(w);
                }
            }
            level++;
        }
        return flag ? deepestNode : level;
    }

    public static void main(String[] args) {
        Problem1245 problem1245 = new Problem1245();
        int[][] edges = {{0,1},{1,2},{2,3},{1,4},{4,5}};
        System.out.println(problem1245.treeDiameter(edges));
    }
}
