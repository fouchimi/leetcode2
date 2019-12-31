public class Problem189 {
    public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k == 0) return;
        int N = nums.length;
        k = k > N ? k % N : k;
        while (k > 0) {
            int last = nums[N - 1];
            for (int i = N - 2; i >= 0; i--) nums[i + 1] = nums[i];
            nums[0] = last;
            k--;
        }
    }

    public static void main(String[] args) {
        Problem189 problem189 = new Problem189();
        problem189.rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
