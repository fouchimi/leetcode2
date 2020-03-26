import java.util.PriorityQueue;

public class Problem1046 {
    public int lastStoneWeight(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((first, second) -> {
            if (first < second) return 1;
            else if (first > second) return -1;
            else return 0;
        });
        for (int stone : stones) pq.offer(stone);
        while (!pq.isEmpty()) {
            if (pq.size() == 1) break;
            int top = pq.poll();
            int diff = top - pq.poll();
            pq.offer(diff);
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        Problem1046 problem1046 = new Problem1046();
        System.out.println(problem1046.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
    }
}
