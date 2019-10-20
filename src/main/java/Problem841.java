import java.util.*;

public class Problem841 {
    int vertices;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int V = rooms.size();
        boolean[] visited = new boolean[V];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int v = 0; v < V; v++) map.put(v, new ArrayList<>());
        for(int v = 0; v < V; v++) {
            List<Integer> roomsList = rooms.get(v);
            for(int room : roomsList) map.get(v).add(room);
        }
        dfs(0, visited, map);
        return vertices == V;
    }

    private void dfs(int s, boolean[] visited, Map<Integer, List<Integer>> map) {
        if(!visited[s]) vertices++;
        visited[s] = true;
        for(int u : map.get(s)) {
            if(!visited[u]) dfs(u, visited, map);
        }
    }

    public static void main(String[] args){
        Problem841 problem841 = new Problem841();
        System.out.println(problem841.canVisitAllRooms(Arrays.asList(Arrays.asList(1, 3), Arrays.asList(3, 0, 1), Arrays.asList(2), Arrays.asList(0))));
    }
}
