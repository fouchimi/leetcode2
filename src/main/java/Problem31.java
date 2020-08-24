
public class Problem31 {
    public void nextPermutation(int[] nums) {
        // Find the longest decreasing suffix
        int j = nums.length - 2;
        while (j >= 0 && nums[j] >= nums[j + 1]) j--;
        if (j == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        for (int l = nums.length - 1; l > j; --l) {
            if (nums[l] > nums[j]) {
                int tmp = nums[l];
                nums[l] = nums[j];
                nums[j] = tmp;
                break;
            }
        }
        reverse(nums, j + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int p, int q) {
        while(p < q) {
            int temp = nums[p];
            nums[p] = nums[q];
            nums[q] = temp;
            p++;
            q--;
        }
    }

    public static void main(String[] args) {
        Problem31 problem31 = new Problem31();
        problem31.nextPermutation(new int[]{1, 2, 3});
        problem31.nextPermutation(new int[]{3, 2, 1});
        problem31.nextPermutation(new int[]{1, 1, 5});
        problem31.nextPermutation(new int[]{1, 3, 2});
        problem31.nextPermutation(new int[]{6, 2, 1, 5, 4, 3, 0});
    }
}
