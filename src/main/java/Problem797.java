import java.util.ArrayList;
import java.util.List;

public class Problem797 {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int V = graph.length;
        boolean[] visited = new boolean[V];
        List<Integer>[] map = new ArrayList[V];
        for (int v = 0; v < V; v++) map[v]  = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            int[] vertices = graph[v];
            for (int w : vertices) map[v].add(w);
        }
        dfs(0, V-1, map, new ArrayList<>(), ans, visited);
        return ans;
    }

    private void dfs(int s, int e, List<Integer>[] map, ArrayList<Integer> list, List<List<Integer>> ans, boolean[] visited) {
        if (s == e) {
            List<Integer> tempList = new ArrayList<>(list);
            tempList.add(0, 0);
            ans.add(tempList);
            return;
        }
        for (int w : map[s]) {
            if (visited[w]) continue;
            list.add(w);
            visited[w] = true;
            dfs(w, e, map, list, ans, visited);
            visited[w] = false;
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem797 problem797 = new Problem797();
        problem797.allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}});
    }
}
