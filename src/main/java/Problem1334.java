import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem1334 {

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<int[]>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int src = edge[0], dst = edge[1], dist = edge[2];
            map[src].add(new int[]{dst, dist});
            map[dst].add(new int[]{src, dist});
        }
        boolean[] visited = new boolean[n];
        int minCount = Integer.MAX_VALUE;
        int city = 0;
        for (int v = 0; v < n; v++) {
            Set<Integer> neighbors = new HashSet<>();
            dfs(v, map, visited, neighbors, 0, distanceThreshold);
            if (neighbors.size() <= minCount) {
                city = v;
                minCount = neighbors.size();
            }
        }
        return city;
    }

    private void dfs(int s, List<int[]>[] map, boolean[] visited, Set<Integer> neighbors, int sumDist, int threshold) {
        visited[s] = true;
        for (int[] w : map[s]) {
            if (!visited[w[0]] && sumDist + w[1] <= threshold) {
                neighbors.add(w[0]);
                dfs(w[0], map, visited, neighbors, sumDist + w[1], threshold);
            }
        }
        visited[s] = false;
    }

    public static void main(String[] args) {
        Problem1334 problem1334 = new Problem1334();
        System.out.println(problem1334.findTheCity(4, new int[][]{{0, 1, 3}, {1, 2, 1}, {1, 3, 4}, {2, 3, 1}}, 4));
        System.out.println(problem1334.findTheCity(5, new int[][]{{0, 1, 2},{0, 4, 8},{1, 2, 3},{1, 4, 2},{2, 3, 1},{3, 4, 1}}, 2));
    }
}
