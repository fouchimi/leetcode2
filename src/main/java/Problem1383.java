
import java.util.*;

public class Problem1383 {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> efficiency[b] - efficiency[a]);
        PriorityQueue<Integer> min_heap = new PriorityQueue<>(Comparator.comparingInt(c -> speed[c]));

        long sum = 0l, result = 0l;

        for(int i = 0; i < efficiency.length; i++) max_heap.offer(i);

        while (!max_heap.isEmpty()) {
            int temp = max_heap.poll();
            min_heap.offer(temp);
            sum = min_heap.size() <= k ? sum + speed[temp] : sum + speed[temp] - speed[min_heap.poll()];
            if (min_heap.size() <= k) {
                result = Math.max(result, sum * efficiency[temp]);
            }
        }

        return (int)(result % 1000000007);
    }


    public static void main(String[] args) {
        Problem1383 problem1383 = new Problem1383();
        System.out.println(problem1383.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2}, 2));
    }
}
