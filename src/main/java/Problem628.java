import java.util.Arrays;

public class Problem628 {
    public int maximumProduct(int[] nums) {
        int N = nums.length;
        if (N < 3) {
            int max = 1;
            for (int val : nums) max *= val;
            return max;
        }
        Arrays.sort(nums);
        return Math.max(nums[0] * nums[1] * nums[2], nums[N-3] * nums[N-2] * nums[N-1]);
    }

    public static void main(String[] args) {
        Problem628 problem628 = new Problem628();
        System.out.println(problem628.maximumProduct(new int[]{1, 2, 3}));
        System.out.println(problem628.maximumProduct(new int[]{1, 2, 3, 4}));
    }
}
