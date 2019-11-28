public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length,  N = nums.length, p = 0;
        while (p < N) {
            int q = p;
            while (q < length && nums[p] == nums[q]) q++;
            int index = q - p - 1, diff = q - p - 2;
            while (index <= q && diff > 0) {
                int k = index;
                while (k + 1 < N) {
                    nums[k] = nums[k + 1];
                    k++;
                }
                nums[--N] = '\0';
                index++;
                diff--;
            }
            int start = p;
            while (p < N && nums[p] == nums[start]) p++;
        }
        return N;
    }

    public static void main(String[] args) {
        Problem80 problem80 = new Problem80();
        int[] nums = {1,1,1,1,3,3};
        System.out.println(problem80.removeDuplicates(nums));
    }
}
