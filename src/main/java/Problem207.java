import java.util.*;

public class Problem207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] inDegrees = new int[numCourses];
        for(int i = 0; i < numCourses; i++) adj.put(i, new ArrayList<>());
        for(int i = 0; i < prerequisites.length; i++) {
            int[] pair = prerequisites[i];
            adj.get(pair[1]).add(pair[0]);
        }
        for(int i = 0; i < numCourses; i++) {
            List<Integer> tempList = adj.get(i);
            for(int w : tempList) {
                inDegrees[w]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int v = 0; v < numCourses; v++) {
            if(inDegrees[v] == 0) queue.offer(v);
        }

        if(queue.isEmpty()) return false;
        List<Integer> order = new ArrayList<>();
        while(!queue.isEmpty()) {
            int u = queue.poll();
            order.add(u);
            for(int w : adj.get(u)) {
                if(--inDegrees[w] == 0) {
                    queue.offer(w);
                }
            }
        }

        return numCourses == order.size();
    }

    public static void main(String[] args) {
        Problem207 problem207 = new Problem207();
        int[][] prerequisites = {{1, 0}};
        System.out.println(problem207.canFinish(2, prerequisites));
    }

}
