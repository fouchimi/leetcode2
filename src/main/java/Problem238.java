public class Problem238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{0};
        int[] res = new int[nums.length];

        int prod1 = nums[0], prod2 = nums[0], countZeros = 0;
        if (nums[0] == 0) countZeros++;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) countZeros++;
            else if (nums[i] != 0) prod2 *= nums[i];
            prod1 *= nums[i];
        }

        if (countZeros > 1) return res;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) res[i] = prod1 / nums[i];
            else res[i] = prod2;
        }

        return res;
    }

    public static void main(String[] args) {
        Problem238 problem238 = new Problem238();
        int[] res = problem238.productExceptSelf(new int[]{2, 3, 0, 0});
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
