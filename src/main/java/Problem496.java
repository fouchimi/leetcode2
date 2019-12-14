import java.util.*;

public class Problem496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans;
        if (nums1 == null) {
            ans = new int[nums2.length];
            Arrays.fill(ans, -1);
            return ans;
        } else if (nums2 == null) {
            ans = new int[nums1.length];
            Arrays.fill(ans, -1);
            return ans;
        } else {
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums2.length; i++) map.put(nums2[i], i);
            for (int i = 0; i < nums1.length; i++) {
                if (!map.containsKey(nums1[i])) list.add(-1);
                else {
                    boolean found = false;
                    int j = map.get(nums1[i]);
                    for (; j < nums2.length; j++) {
                        if (nums2[j] > nums1[i]) {
                            found = true;
                            break;
                        }
                    }
                    if (found) list.add(nums2[j]);
                    else list.add(-1);
                }
            }
            ans = new int[list.size()];
            for (int i = 0; i < list.size(); i++) ans[i] = list.get(i);
            return ans;
        }
    }

    public static void main(String[] args) {
        Problem496 problem496 = new Problem496();
        int[] res = problem496.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});
        for(int val : res) {
            System.out.print(val + " ");
        }
    }
}
