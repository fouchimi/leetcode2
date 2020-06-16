import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Problem1338 {

    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int mid = arr.length / 2;
        for (int value : arr) map.put(value, map.getOrDefault(value, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer, Integer> entry : map.entrySet())  pq.offer(entry);
        while (mid > 0 && !pq.isEmpty()) {
            Map.Entry<Integer, Integer> topEntry = pq.poll();
            int value = topEntry.getValue();
            if (value >= mid) {
                value -= mid;
                topEntry.setValue(value);
                if (topEntry.getValue() > 0) pq.offer(topEntry);
                mid = 0;
            } else {
                mid -= value;
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        Problem1338 problem1338 = new Problem1338();
        System.out.println(problem1338.minSetSize(new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7}));
        System.out.println(problem1338.minSetSize(new int[]{7, 7, 7, 7, 7, 7}));
        System.out.println(problem1338.minSetSize(new int[]{1, 9}));
        System.out.println(problem1338.minSetSize(new int[]{1000, 1000, 3, 7}));
        System.out.println(problem1338.minSetSize(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
