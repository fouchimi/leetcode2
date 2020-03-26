import java.util.*;

public class Problem128 {
    public int longestConsecutive(int[] nums) {

        if (nums == null || nums.length == 0) return 0;

        Map<Integer, Integer> numMap = new HashMap<>();
        Map<Integer, Boolean> visited = new HashMap<>();

        for (int num : nums) {
            numMap.put(num, num);
            visited.put(num, false);
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == Integer.MAX_VALUE && numMap.containsKey(val - 1)) {
                union(graph, val, val - 1);
                continue;
            }
            if (val == Integer.MIN_VALUE && numMap.containsKey(val + 1)) {
                union(graph, val, val + 1);
                continue;
            }

            if (numMap.containsKey(val + 1)) union(graph, val, val + 1);
            if (numMap.containsKey(val - 1)) union(graph, val, val - 1);
        }

        int max = 0;
        for(int u : nums) {
            int[] value = new int[1];
            if (graph.containsKey(u) && !visited.get(u)) {
                dfs(u, graph, visited, value);
                max = Math.max(max, value[0]);
            }
        }
        return max == 0 ? 1 : max;
    }

    private void union(Map<Integer, Set<Integer>> map, int u, int v) {
        if (!map.containsKey(u)) map.put(u, new HashSet<>());
        if (!map.containsKey(v)) map.put(v, new HashSet<>());
        map.get(u).add(v);
        map.get(v).add(u);
    }

    private void dfs(int u, Map<Integer, Set<Integer>> graph, Map<Integer, Boolean> visited, int[] value) {
        if (visited.get(u)) return;
        value[0]++;
        visited.put(u, true);
        for(Integer w : graph.get(u)) {
            dfs (w, graph, visited, value);
        }
    }

    public static void main(String[] args) {
        Problem128 problem128 = new Problem128();
        //System.out.println(problem128.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(problem128.longestConsecutive(new int[]{0}));
    }
}
