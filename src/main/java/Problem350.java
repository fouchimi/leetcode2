import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{};
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        for (int val : nums1) firstMap.put(val, firstMap.getOrDefault(val, 0) + 1);
        for (int val : nums2) secondMap.put(val, secondMap.getOrDefault(val, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (Integer key : firstMap.keySet()) {
            if (secondMap.containsKey(key)) {
                int min = Math.min(firstMap.get(key), secondMap.get(key));
                while (min > 0) {
                    list.add(key);
                    min--;
                }
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
        return res;
    }
}
