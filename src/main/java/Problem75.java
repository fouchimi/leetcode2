import java.util.*;

public class Problem75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = nums[i];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            while (value > 0) {
                nums[index] = entry.getKey();
                value--;
                index++;
            }
        }
    }

    public static void main(String[] args) {
        Problem75 problem75 = new Problem75();
        int[] nums = {2,0,2,1,1,0};
        problem75.sortColors(nums);
    }

}
