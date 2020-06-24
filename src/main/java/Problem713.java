public class Problem713 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, start = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while (prod >= k) {
                prod /= nums[start];
                start++;
            }
            count += i - start + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        Problem713 problem713 = new Problem713();
        System.out.println(problem713.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
        System.out.println(problem713.numSubarrayProductLessThanK(new int[] {1, 1, 1}, 2));
    }
}
