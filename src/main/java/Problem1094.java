import java.util.Comparator;
import java.util.PriorityQueue;

public class Problem1094 {
    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] t1, int[] t2) {
                return t1[0] == t2[0] ? t1[1] - t2[1] : t1[0] - t2[0];
            }
        });
        for (int[] trip : trips) {
            pq.offer(new int[]{trip[1], 1, trip[0]});
            pq.offer(new int[]{trip[2], 0, trip[0]});
        }
        int totalCapacity = capacity;
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            if (top[1] == 1) {
                if (top[2] > totalCapacity) return false;
                totalCapacity -= top[2];
            } else {
                totalCapacity += top[2];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Problem1094 problem1094 = new Problem1094();
        System.out.println(problem1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4));
        System.out.println(problem1094.carPooling(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5));
        System.out.println(problem1094.carPooling(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3));
        System.out.println(problem1094.carPooling(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11));
        System.out.println(problem1094.carPooling(new int[][]{{9, 3, 6},{8, 1, 7},{6, 6, 8}, {8, 4, 9},{4, 2, 9}}, 28));
        System.out.println(problem1094.carPooling(new int[][]{{5, 4, 7}, {7, 4, 8}, {4, 1, 8}}, 17));
    }
}
