public class Problem55 {

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int i = 0;
        while (i + nums[i] <= nums.length - 1) {
            if (nums[i] == 0) break;
            int maxValIndex = 0;
            int maxVal = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[i + j] + j > maxVal) {
                    maxVal = nums[i + j] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
        }
        return i + nums[i] >= nums.length - 1;
    }

    public static void main(String[] args) {
        Problem55 problem55 = new Problem55();
        System.out.println(problem55.canJump(new int[]{2,3,1,1,4}));
        System.out.println(problem55.canJump(new int[]{3, 2, 1, 0, 4}));
        System.out.println(problem55.canJump(new int[]{1, 2}));
        System.out.println(problem55.canJump(new int[]{2, 0}));
    }
}
