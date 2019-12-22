public class Problem396 {

    public int maxRotateFunction(int[] A) {
        int max = Integer.MIN_VALUE;
        int i = 0;
        while (i < A.length) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) sum += A[j] * j;
            max = Math.max(sum, max);
            shiftClockWise(A);
            i++;
        }
        return max;
    }

    private void shiftClockWise(int[] nums) {
        int last = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) nums[i + 1] = nums[i];
        nums[0] = last;
    }

    public static void main(String[] args) {
        Problem396 problem396 = new Problem396();
        System.out.println(problem396.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
