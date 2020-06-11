public class Problem1464 {
    public int maxProduct(int[] nums) {
        int maxProduct = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i + 1; j <= nums.length; j++) {
                maxProduct = Math.max(maxProduct, (nums[i - 1] - 1) * (nums[j - 1] - 1));
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        Problem1464 problem1464 = new Problem1464();
        System.out.println(problem1464.maxProduct(new int[]{3,4,5,2}));
        System.out.println(problem1464.maxProduct(new int[]{1,5,4,5}));
        System.out.println(problem1464.maxProduct(new  int[]{3,7}));
    }
}
