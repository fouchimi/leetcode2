import java.util.*;

public class Problem210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        int[] result = new int[numCourses];
        for(int v = 0; v < numCourses; v++) map.put(v, new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            map.get(pair[1]).add(pair[0]);
        }
        for(int v = 0; v < numCourses; v++) {
            for(int u : map.get(v)) inDegrees[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int v = 0; v < numCourses; v++) {
            if(inDegrees[v] == 0) q.offer(v);
        }
        int index = 0;
        if(q.isEmpty()) return new int[0];

        while (!q.isEmpty()) {
            int u = q.poll();
            result[index] = u;
            for(int w : map.get(u)) {
                if(--inDegrees[w] == 0) {
                    q.offer(w);
                }
            }
            index++;
        }
        return index < numCourses ? new int[0] : result;
    }

    public static void main(String[] args) {
        Problem210 problem210 = new Problem210();
        int[][] prerequisites = {{1, 0}, {1, 2}, {0, 1}};
        int[] result = problem210.findOrder(3, prerequisites);
        for(int v : result) {
            System.out.print(v + " ");
        }
    }

}
