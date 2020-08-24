import java.util.PriorityQueue;

public class Problem452 {
    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] != p2[1] ? p1[1] - p2[1] : p1[0] - p2[0]);
        for(int[] point : points) pq.offer(point);
        int[] last = null;
        int minCount = points.length;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (last != null && last[1] >= top[0]) {
                minCount--;
                continue;
            }
            last = top;
        }
        return minCount;
    }

    public static void main(String[] args) {
        Problem452 problem452 = new Problem452();
        System.out.println(problem452.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
    }
}
