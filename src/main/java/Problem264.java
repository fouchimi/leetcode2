import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Problem264 {

    public int nthUglyNumber(int n) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        Set<Long> seen = new HashSet<>();
        int[] primes = new int[] {2, 3, 5};
        minHeap.add(1L);
        for (int i = 1; i < n; i++) {
            if (minHeap.isEmpty()) break;
            long minUgly = minHeap.poll();
            for (int mul : primes) {
                long ugly = mul * minUgly;
                if (!seen.contains(ugly)) {
                    minHeap.add(ugly);
                    seen.add(ugly);
                }
            }
        }
        return minHeap.isEmpty() ? 0 : minHeap.peek().intValue();
    }

    public static void main(String[] args) {
        Problem264 problem264 = new Problem264();
        System.out.println(problem264.nthUglyNumber(10));
    }
}
