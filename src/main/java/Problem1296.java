import java.util.*;

public class Problem1296 {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (k > nums.length) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) pq.offer(entry);

        int K = k;
        while (!pq.isEmpty()) {
            List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
            Map.Entry<Integer, Integer> lastEntry = null;
            while (k > 0 && !pq.isEmpty()) {
                Map.Entry<Integer, Integer> entry = pq.poll();
                if (lastEntry != null && entry.getKey()- 1 > lastEntry.getKey()) return false;
                if (entry.getValue() > 0) {
                    if (entry.getValue() > 1) {
                        entry.setValue(entry.getValue() - 1);
                        list.add(entry);
                    }
                    k--;
                    lastEntry = entry;
                }
            }
            if (pq.isEmpty() && k > 0) return false;
            else {
                while (!list.isEmpty()) pq.offer(list.remove(0));
                k = K;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Problem1296 problem1296 = new Problem1296();
        System.out.println(problem1296.isPossibleDivide(new int[]{1,2,3,3,4,4,5,6}, 4));
        System.out.println(problem1296.isPossibleDivide(new int[]{3,2,1,2,3,4,3,4,5,9,10,11}, 3));
        System.out.println(problem1296.isPossibleDivide(new int[]{3,3,2,2,1,1}, 3));
        System.out.println(problem1296.isPossibleDivide(new int[]{1,2,3,4,5,1,2,3,4,5,1,2,3,4}, 5));
    }
}
