import java.util.*;

public class Problem347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Map<Integer, Integer> map = new HashMap<>();
        for (int  val : nums) map.put(val, map.getOrDefault(val, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.getValue() < o2.getValue()) return 1;
            else if (o1.getValue() > o2.getValue()) return -1;
            else return 0;
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);

        while (k > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> entry  = pq.remove();
            res.add(entry.getKey());
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem347 problem347 = new Problem347();
        System.out.println(problem347.topKFrequent(new int[]{1,1,1,2,2,3}, 2));
    }
}
