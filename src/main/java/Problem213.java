public class Problem213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        else if (nums.length == 1) return nums[0];
        else if (nums.length == 2) return Math.max(nums[0], nums[1]);
        else {
            int N = nums.length;
            int[] forward = new int[N], backward = new int[N];
            forward[0] = nums[0];
            forward[1] = Math.max(nums[0], nums[1]);
            backward[N - 1] = nums[N - 1];
            backward[N - 2] = Math.max(nums[N - 1], nums[N - 2]);
            for (int i = 2; i < N - 1; i++) {
                forward[i] = Math.max(nums[i] + forward[i - 2], forward[i - 1]);
            }
            for (int i = N - 3; i >= 1; i--) {
                backward[i] = Math.max(nums[i] + backward[i + 2], backward[i + 1]);
            }
            return Math.max(forward[N - 2], backward[1]);
        }
    }

    public static void main(String[] args) {
        Problem213 problem213 = new Problem213();
        System.out.println(problem213.rob(new int[]{1,2,3,1}));
        System.out.println(problem213.rob(new int[]{2,3,2}));
    }
}
