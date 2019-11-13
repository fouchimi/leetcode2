public class Problem81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return false;
        int i = 1;
        while (i < nums.length && nums[i-1] <= nums[i]) i++;
        return binarySearch(nums, 0, i-1, target) || binarySearch(nums, i, nums.length-1, target);
    }

    private boolean binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return true;
        else if (nums[mid] > target) return binarySearch(nums, lo, mid - 1, target);
        else return binarySearch(nums, mid + 1, hi, target);
    }

    public static void main(String[] args) {
        Problem81 problem81 = new Problem81();
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println(problem81.search(nums, 3));
    }
}
