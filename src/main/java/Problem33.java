public class Problem33 {
    public int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    private int helper(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi-lo) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] > target) {
            if (nums[mid] > nums[hi] && target <= nums[hi]) return helper(nums, mid + 1, hi, target);
            else return helper(nums, lo, mid - 1, target);
        } else {
            if (nums[mid] < nums[lo] && target >= nums[lo]) return helper(nums, lo, mid - 1, target);
            else return helper(nums, mid + 1, hi, target);
        }
    }

    public static void main(String[] args) {
        Problem33 problem33 = new Problem33();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(problem33.search(nums, 3));
    }
}
