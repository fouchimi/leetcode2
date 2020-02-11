import java.util.*;

public class Problem313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        minHeap.offer(1L);
        for (int i = 1; i < n; i++) {
            if (minHeap.isEmpty()) break;
            long minUgly = minHeap.poll();
            for (int mul : primes) {
                long ugly = mul * minUgly;
                if (seen.add(ugly)) minHeap.offer(ugly);
            }
        }
        return minHeap.isEmpty() ? 0 : minHeap.peek().intValue();
    }

    public static void main(String[] args) {
        Problem313 problem313 = new Problem313();
        System.out.println(problem313.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
    }
}
