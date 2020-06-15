import java.util.PriorityQueue;

public class Problem435 {

    public int eraseOverlapIntervals(int[][] intervals) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] != p2[1] ? p1[1] - p2[1] : p1[0] - p2[0]);
        for (int[] interval : intervals) pq.offer(interval);
        int[] last = null;
        int minCount = 0;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (last != null && last[1] > top[0]){
                minCount++;
                continue;
            }
            last = top;
        }
        return minCount;
    }

    public static void main(String[] args) {
        Problem435 problem435 = new Problem435();
        System.out.println(problem435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        System.out.println(problem435.eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        System.out.println(problem435.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}}));
    }
}
