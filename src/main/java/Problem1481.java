import java.util.*;

public class Problem1481 {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        if (arr == null || arr.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int val : arr)  map.put(val, map.getOrDefault(val, 0) + 1);
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue));

        for (int i = 0; i < list.size() && k > 0; i++) {
            Map.Entry<Integer, Integer> currentEntry = list.get(i);
            int value = currentEntry.getValue();
            if (value <= k) currentEntry.setValue(0);
            else currentEntry.setValue(value - k);
            k -= value;
        }

        int count = 0;
        for (Map.Entry<Integer, Integer> entry :  list) {
            if (entry.getValue() > 0) count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Problem1481 problem1481 = new Problem1481();
        System.out.println(problem1481.findLeastNumOfUniqueInts(new int[]{5, 5, 4}, 1));
        System.out.println(problem1481.findLeastNumOfUniqueInts(new int[]{4,3,1,1,3,3,2}, 3));
    }
}
