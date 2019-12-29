import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, List<Integer>> mapIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            if (!map.containsKey(key)) {
                map.put(key, 1);
                List<Integer> list = new ArrayList<>();
                list.add(i);
                mapIndex.put(key, list);
            } else {
                map.put(key, map.getOrDefault(key, 0) + 1);
                mapIndex.get(key).add(i);
            }
        }

        for (Map.Entry<Integer, Integer>  entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                List<Integer> list = mapIndex.get(entry.getKey());
                for (int i = 0; i < list.size(); i++) {
                    for (int j = i + 1; j < list.size(); j++) {
                        if (list.get(j) - list.get(i) <= k) return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem219 problem219 = new Problem219();
        System.out.println(problem219.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(problem219.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(problem219.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
