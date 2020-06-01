import java.util.*;

public class Problem802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> res = new ArrayList<>();
        if (graph == null || graph.length == 0) return res;
        int N = graph.length;
        List<Integer>[] map = new ArrayList[N];
        for (int v = 0; v < N; v++) map[v] = new ArrayList<>();
        for (int v = 0; v < N; v++) {
            int[] nodes = graph[v];
            for (int node : nodes) map[v].add(node);
        }

        boolean[] visited = new boolean[N];
        Set<Integer> badNodes = new HashSet<>(), goodNodes = new HashSet<>();
        for (int v = 0; v < N; v++) {
            if (visited[v] || badNodes.contains(v) || goodNodes.contains(v)) continue;
            if(dfs(v, map, visited, badNodes, goodNodes)) {
                goodNodes.add(v);
            }
        }
        res.addAll(goodNodes);
        Collections.sort(res);
        return res;
    }

    private boolean dfs(int s, List<Integer>[] map, boolean[] visited, Set<Integer> badNodes, Set<Integer> goodNodes) {
        if (visited[s] || badNodes.contains(s)) return false;
        if (map[s].size() == 0) return true;
        visited[s] = true;
        for (int w : map[s]) {
            if (goodNodes.contains(w)) continue;
            if (!dfs(w, map, visited, badNodes, goodNodes)) {
                badNodes.add(w);
                return false;
            }
            goodNodes.add(w);
        }
        visited[s] = false;
        return true;
    }

    public static void main(String[] args) {
        Problem802 problem802 = new Problem802();
        System.out.println(problem802.eventualSafeNodes(new int[][]{{1, 2}, {2, 3}, {5}, {0}, {5}, {}, {}}));
        System.out.println(problem802.eventualSafeNodes(new int[][]{{},{0,2,3,4},{3},{4},{}}));
        System.out.println(problem802.eventualSafeNodes(new int[][]{{0},{2,3,4},{3,4},{0,4},{}}));
    }
}
