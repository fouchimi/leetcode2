import java.util.HashMap;
import java.util.Map;

public class Problem697 {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> minIndexMap = new HashMap<>();
        Map<Integer, Integer> maxIndexMap = new HashMap<>();
        int maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (!minIndexMap.containsKey(nums[i])) minIndexMap.put(nums[i], i);
            if (!maxIndexMap.containsKey(nums[i])) maxIndexMap.put(nums[i], i);
            minIndexMap.put(nums[i], Math.min(minIndexMap.get(nums[i]), i));
            maxIndexMap.put(nums[i], Math.max(maxIndexMap.get(nums[i]), i));
            maxFreq = Math.max(maxFreq, map.get(nums[i]));
        }

        int result = Integer.MAX_VALUE;

        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                result = Math.min(result, (maxIndexMap.get(key) - minIndexMap.get(key) + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Problem697 problem697 = new Problem697();
        System.out.println(problem697.findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
        System.out.println(problem697.findShortestSubArray(new int[]{1, 2, 2, 3, 1, 4, 2}));
    }
}
