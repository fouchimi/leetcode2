import java.util.PriorityQueue;

public class Problem275 {
    public int hIndex(int[] citations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((first, second) -> second - first);
        for (int citation : citations) pq.offer(citation);
        int h = 0;
        for (; !pq.isEmpty() && h < pq.peek(); ++h) pq.poll();
        return h;
    }
}
