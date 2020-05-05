
public class Problem416 {

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int sum = 0, length = nums.length;
        for (int i = 0; i < length; i++) sum += nums[i];

        if (sum % 2 != 0) return false;
        int target = sum / 2;
        boolean[] memo = new boolean[target + 1];
        boolean[] visited = new boolean[target + 1];
        return canPartitionUtil(nums, target, 0,  memo, visited);
    }

    private boolean canPartitionUtil(int[] nums,  int target, int index,  boolean[] memo, boolean[] visited) {
        if (target < 0 || index >= nums.length) return false;
        if (target == 0) return true;
        if (visited[target]) return memo[target];
        boolean result = canPartitionUtil(nums, target - nums[index], index + 1, memo, visited) || canPartitionUtil(nums, target, index + 1, memo, visited);
        visited[target] = true;
        memo[target] = result;
        return result;
    }


    public static void main(String[] args) {
        Problem416 problem416 = new Problem416();
        System.out.println(problem416.canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(problem416.canPartition(new int[]{1, 2, 3, 5}));
        System.out.println(problem416.canPartition(new int[]{3, 3, 3, 4, 5}));
        System.out.println(problem416.canPartition(new int[]{1, 1}));
        System.out.println(problem416.canPartition(new int[] {1, 2, 3, 4, 5, 6, 7}));
    }
}
