public class Problem27 {
    public int removeElement(int[] nums, int val) {
        int p = 0, N = nums.length;
        while (p < N) {
            if (nums[p] == val) {
                int q = p + 1;
                if (q == nums.length) nums[p] = '\0';
                while(q < N) {
                    nums[q-1] = nums[q];
                    q++;
                }
                nums[N - 1] = '\0';
                N--;
            }
            if (nums[p] != val) p++;
        }
//        for (int i = 0; i < nums.length; i++) {
//            System.out.print(nums[i] + " ");
//        }
//        System.out.println();
        return N;
    }

    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();
        int[] nums = {1};
        System.out.println(problem27.removeElement(nums, 1));
    }
}
