import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Problem414 {

    public int thirdMax(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else {
           Map<Integer, Integer> map = new TreeMap<>((e1, e2) -> {
               if (e1 < e2) return 1;
               else if (e1 > e2) return -1;
               else return 0;
           });
           for (int val : nums) map.put(val, val);
           if (map.size() < 3) return map.keySet().iterator().next();
           else {
               int i = 0;
               Iterator<Integer> itr = map.keySet().iterator();
               int max = 0;
               while (itr.hasNext() && i < 3) {
                   max = itr.next();
                   i++;
               }
               return max;
           }
        }
    }

    public static void main(String[] args) {
        Problem414 problem414 = new Problem414();
        System.out.println(problem414.thirdMax(new int[]{2, 2, 3, 1}));
        System.out.println(problem414.thirdMax(new int[]{1, 1, 2}));
    }
}
