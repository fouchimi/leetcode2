import java.util.PriorityQueue;

public class Problem1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : A) pq.offer(val);
        while (K > 0 && !pq.isEmpty()) {
            int top = pq.poll();
            pq.offer(-top);
            K--;
        }

        int res = 0;
        while (!pq.isEmpty()) res += pq.poll();
        return res;
    }

    public static void main(String[] args) {
        Problem1005 problem1005 = new Problem1005();
        System.out.println(problem1005.largestSumAfterKNegations(new int[]{4, 2, 3}, 1));
        System.out.println(problem1005.largestSumAfterKNegations(new int[]{3, -1, 0, 2}, 3));
        System.out.println(problem1005.largestSumAfterKNegations(new int[]{2, -3, -1, 5, -4}, 2));
    }
}
