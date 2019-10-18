import java.util.*;

public class Problem847 {

    public int shortestPathLengthSlow(int[][] graph) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int V = graph.length;

        for(int v = 0; v < V; v++) map.put(v, new ArrayList<>());

        for(int v = 0; v < V; v++) {
            int[] neighbors = graph[v];
            for (int neighbor : neighbors) map.get(v).add(neighbor);
        }

        List<Map.Entry<Integer, List<Integer>>> keyList = new ArrayList<>(map.entrySet());

        keyList.sort((first, second) -> {
            if (first.getValue().size() < second.getValue().size()) return -1;
            else if (first.getValue().size() > second.getValue().size()) return 1;
            else return 0;
        });

        int minSize = keyList.get(0).getValue().size(), i = 0;
        List<Integer> startList = new ArrayList<>();

        while (i < keyList.size() && keyList.get(i).getValue().size() == minSize) {
            startList.add(keyList.get(i).getKey());
            i++;
        }

        int min = Integer.MAX_VALUE;
        for(int v : startList) {
            min = Math.min(min, bfs(v, V, map));
        }
        return min;
    }

    private int bfs(int s, int V, Map<Integer, List<Integer>> map) {
        Deque<List<Integer>> q = new ArrayDeque<>();
        List<Integer> path = new ArrayList<>();
        path.add(s);
        q.add(path);
        while ((!q.isEmpty())) {
            List<Integer> currentPath = q.poll();
            if(isFullyExplored(currentPath, V)) return currentPath.size() - 1;
            int lastVertex = currentPath.get(currentPath.size()-1);
            for(int neighbor : map.get(lastVertex)) {
                List<Integer> tempPath = new ArrayList<>(currentPath);
                tempPath.add(neighbor);
                q.offer(tempPath);
            }
        }
        return 0;
    }

    private boolean isFullyExplored(List<Integer> path, int V) {
        Set<Integer> set = new HashSet<>(path);
        return set.size() == V;
    }

    public int shortestPathLength(int[][] graph) {
        Queue<int[]> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int target = 0;
        for (int i = 0; i < graph.length; i++) {
            int status = (1 << (i+1));
            target = target | (1 << (i+1));
            visited.add(status + ":" + i);
            q.offer(new int[]{status, i});
        }
        int numThisLevel = q.size(), numNextLevel = 0, level = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            numThisLevel --;
            if (cur[0] == target) return level;
            for (int i = 0; i < graph[cur[1]].length; i++) {
                int nextNode = graph[cur[1]][i];
                int nextStatus = cur[0] | (1 << (nextNode + 1));
                if (visited.contains(nextStatus + ":" + nextNode)) continue;
                visited.add(nextStatus + ":" + nextNode);
                q.offer(new int[]{nextStatus, nextNode});
                numNextLevel++;
            }
            if (numThisLevel == 0) {
                numThisLevel = numNextLevel;
                numNextLevel = 0;
                level++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem847 problem847 = new Problem847();
        int[][] graph = {{1},{0,2,4},{1,3},{2},{1,5},{4}};
        System.out.println(problem847.shortestPathLength(graph));
    }

}
