import java.util.HashMap;

public class Problem494 {
    public int findTargetSumWays(int[] nums, int S) {
        return dfs(0, nums, S, 0, new HashMap<>());
    }

    private int dfs(int currSum, int[] nums, int S, int currentIndex, HashMap<String, Integer> map) {
        String key = currentIndex + "#" + currSum;
        if (map.containsKey(key)) return map.get(key);
        if (currentIndex == nums.length) {
            return currSum == S ? 1 : 0;
        } else  {
            int left = currSum - nums[currentIndex];
            int right = currSum + nums[currentIndex];
            int count = dfs(left, nums, S, currentIndex + 1, map);
            count += dfs(right, nums, S, currentIndex + 1, map);
            map.put(key, count);
            return count;
        }
    }

    public static void main(String[] args) {
        Problem494 problem494 = new Problem494();
        System.out.println(problem494.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
