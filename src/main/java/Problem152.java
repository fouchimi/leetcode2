public class Problem152 {
    public int maxProduct(int[] nums) {
        int r = nums[0];

        for (int i = 1, imin = r, imax = r; i < nums.length; i++) {

            if (nums[i] < 0) {
                int temp = imax;
                imax = imin;
                imin = temp;
            }

            imax = Math.max(nums[i], nums[i] * imax);
            imin = Math.min(nums[i], nums[i] * imin);

            r = Math.max(r, imax);
        }

        return r;
    }

    public static void main(String[] args) {
        Problem152 problem152 = new Problem152();
        System.out.println(problem152.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(problem152.maxProduct(new int[]{-2, 0, -1}));
        System.out.println(problem152.maxProduct(new int[]{-4, -3}));
        System.out.println(problem152.maxProduct(new int[]{-1, -1}));
        System.out.println(problem152.maxProduct(new int[]{-4, -3, -2}));
        System.out.println(problem152.maxProduct(new int[]{-2, 3, -4}));
    }
}
