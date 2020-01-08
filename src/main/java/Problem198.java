public class Problem198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else {
            int[] runningTotal = new int[nums.length];
            runningTotal[0] = nums[0];
            runningTotal[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                runningTotal[i] = Math.max(nums[i] + runningTotal[i - 2], runningTotal[i - 1]);
            }
            return runningTotal[runningTotal.length - 1];
        }
    }

    public static void main(String[] args) {
        Problem198 problem198 = new Problem198();
        System.out.println(problem198.rob(new int[]{1, 2, 3, 1}));
        System.out.println(problem198.rob(new int[]{2, 7, 9, 3, 1}));
    }
}
