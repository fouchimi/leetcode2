import java.util.*;

public class Problem349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[]{0};
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int key : nums1) map.put(key, key);
        for (int val : nums2) {
            if (map.containsKey(val)) set.add(val);
        }
        int[] res = new int[set.size()];
        Iterator<Integer> itr = set.iterator();
        int index = 0;
        while (itr.hasNext()) {
            res[index] = itr.next();
            index++;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem349 problem349 = new Problem349();
        int[] res = problem349.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i] + " ");
        }
    }
}
