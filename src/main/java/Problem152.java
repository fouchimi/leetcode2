public class Problem152 {
    public int maxProduct(int[] nums) {
        int p = 0, maxProduct = Integer.MIN_VALUE;
        while (p < nums.length) {
            int q = p + 1, product = nums[p];
            while (q < nums.length  && nums[q] == nums[q-1] + 1) {
                product = Math.max(product, product * nums[q]);
                q++;
            }
            while (q < nums.length && nums[p] == nums[q]) {
                product = Math.max(product, product * nums[q]);
                q++;
            }
            maxProduct = Math.max(product, maxProduct);
            p = q;
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Problem152 problem152 = new Problem152();
        System.out.println(problem152.maxProduct(new int[]{2, 3, -2, 4}));
        System.out.println(problem152.maxProduct(new int[]{-2,0,-1}));
        System.out.println(problem152.maxProduct(new int[]{-4, -3}));
        System.out.println(problem152.maxProduct(new int[]{-1, -1}));
        System.out.println(problem152.maxProduct(new int[]{-4,-3,-2}));
        System.out.println(problem152.maxProduct(new int[]{-2, 3, -4}));
    }
}
