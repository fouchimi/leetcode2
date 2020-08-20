public class Problem35 {
    public int searchInsert(int[] nums, int target) {
        return searchInsertUtil(nums, 0, nums.length - 1, target);
    }

    private int searchInsertUtil(int[] nums, int lo, int hi, int target) {
        if (lo > hi) {
            if (target < nums[lo]) return lo;
            else return hi;
        }
        if (lo == hi && nums[lo] != target) {
            if (hi == nums.length - 1) {
                if (target > nums[hi]) return hi + 1;
                else return hi;
            } else if (lo == 0) {
                if (target > nums[lo]) return lo + 1;
                return lo;
            } else if (target < nums[lo]) return lo;
            else return lo + 1;
        }
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] > target) {
            return searchInsertUtil(nums, lo, mid - 1, target);
        } else {
            return searchInsertUtil(nums, mid + 1, hi, target);
        }
    }

    public static void main(String[] args) {
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(problem35.searchInsert(new int[]{1, 3, 5, 6}, 0));
        System.out.println(problem35.searchInsert(new int[]{1, 3}, 2));
        System.out.println(problem35.searchInsert(new int[]{1, 3}, 0));
        System.out.println(problem35.searchInsert(new int[]{3, 5, 7, 9, 10}, 8));
        System.out.println(problem35.searchInsert(new int[]{3, 6, 7, 8, 10}, 5));
    }
}
