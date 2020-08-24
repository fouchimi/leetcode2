import java.util.PriorityQueue;

public class Problem274 {

    public int hIndex(int[] citations) {
        int h = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((first, second) -> second - first);
        for (int citation : citations) pq.offer(citation);
       for(; !pq.isEmpty() && h < pq.peek(); ++h) pq.poll();
        return h;
    }

    public static void main(String[] args) {
        Problem274 problem274 = new Problem274();
        System.out.println(problem274.hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(problem274.hIndex(new int[]{0}));
        System.out.println(problem274.hIndex(new int[]{100}));
        System.out.println(problem274.hIndex(new int[]{0, 0}));
        System.out.println(problem274.hIndex(new int[]{1, 2}));
        System.out.println(problem274.hIndex(new int[]{11, 15}));
        System.out.println(problem274.hIndex(new int[]{0, 1}));
        System.out.println(problem274.hIndex(new int[]{0, 1, 1}));
    }
}
