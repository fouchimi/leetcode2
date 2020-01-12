public class Problem283 {
    public void moveZeroes(int[] nums) {
        int N = nums.length - 1;
       for (int i = N; i >= 0; i--) {
           if (nums[i] == 0) {
               for (int j = i; j < N; j++) {
                   nums[j] = nums[j + 1];
               }
               nums[N] = 0;
               N--;
           }
       }
    }

    public static void main(String[] args) {
        Problem283 problem283 = new Problem283();
        problem283.moveZeroes(new int[]{0, 1, 0, 3, 12});
        problem283.moveZeroes(new int[] {0, 0, 1});
    }
}
