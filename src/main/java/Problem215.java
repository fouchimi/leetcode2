import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem215 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int val : nums) map.put(val, map.getOrDefault(val, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getKey() < o2.getKey()) return 1;
            else if (o1.getKey() > o2.getKey()) return -1;
            else return 0;
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);
        int last = Integer.MIN_VALUE;
        while (k > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry = pq.peek();
            entry.setValue(entry.getValue() - 1);
            last = entry.getKey();
            if (entry.getValue() == 0) pq.remove();
            k--;
        }
        return last;
    }

    public static void main(String[] args) {
        Problem215 problem215 = new Problem215();
        System.out.println(problem215.findKthLargest(new int[]{99, 99}, 1));
    }
}
