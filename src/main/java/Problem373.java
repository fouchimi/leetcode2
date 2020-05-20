import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Problem373 {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((first, second) -> {
            int firstSum = first.get(0) + first.get(1);
            int secondSum = second.get(0) + second.get(1);
            if (firstSum < secondSum) return -1;
            else if (firstSum > secondSum) return 1;
            return 0;
        });

        for (int item : nums1) {
            for (int value : nums2) {
                List<Integer> list = Arrays.asList(item, value);
                pq.offer(list);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        while (k > 0 && !pq.isEmpty()) {
            res.add(pq.poll());
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem373 problem373 = new Problem373();

    }
}
