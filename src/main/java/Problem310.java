import java.util.*;

public class Problem310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();
        if(n == 0) return res;
        if(n == 1) {
            res.add(0);
            return res;
        }
        int V = n;
        int[] inDegrees = new int[V];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int v = 0; v < V; v++) map.put(v, new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int[] pair = edges[i];
            map.get(pair[0]).add(pair[1]);
            map.get(pair[1]).add(pair[0]);
            inDegrees[pair[0]]++;
            inDegrees[pair[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if (inDegrees[i] == 1) q.offer(i);
        }

        while (!q.isEmpty()) {
            int len = q.size();
            res = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                if (q.isEmpty()) break;
                int top = q.poll();
                res.add(top);
                for (int w : map.get(top)) {
                    inDegrees[w]--;
                    if (inDegrees[w] == 1) q.offer(w);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Problem310 problem310 = new Problem310();
        int[][] edges = {{1,0},{1,2},{1,3}};
        List<Integer> res = problem310.findMinHeightTrees(4, edges);
        System.out.println(res);
    }
}
