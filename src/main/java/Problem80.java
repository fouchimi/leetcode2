public class Problem80 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int length = nums.length,  N = nums.length, p = 0;
        while (p < N) {
            int q = p;
            while (q < length && nums[p] == nums[q]) q++;
            int index = q - p - 2;
            while (index > 0) {
                for (int i = q; i < N; i++) nums[i - 1] = nums[i];
                nums[--N] = '\0';
                q--;
                index--;
            }
            p = q;
        }
        return N;
    }

    public static void main(String[] args) {
        Problem80 problem80 = new Problem80();
        int[] nums = {1,1,1,2,2,3};
        //int[] nums = {0,0,1,1,1,1,2,3,3};
        System.out.println(problem80.removeDuplicates(nums));
    }
}
