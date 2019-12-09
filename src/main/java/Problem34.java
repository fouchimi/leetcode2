public class Problem34 {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;
        binarySearch(nums, 0, nums.length - 1, target, res);
        return res;
    }

    private void binarySearch(int[] nums, int lo, int hi, int target, int[] res) {
        if (lo > hi) return;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) {
            if (res[0] < 0 && res[1] < 0) {
                res[0] = mid;
                res[1] = mid;
            } else {
                res[0] = Math.min(res[0], mid);
                res[1] = Math.max(res[1], mid);
            }
        }
        binarySearch(nums, lo, mid - 1, target, res);
        binarySearch(nums, mid + 1, hi, target, res);
    }

    public static void main(String[] args) {
        Problem34 problem34 = new Problem34();
        int[] nums = {3, 3, 3};
        int[] res = problem34.searchRange(nums, 3);
        System.out.println(res[0] + " " + res[1]);
    }
}
