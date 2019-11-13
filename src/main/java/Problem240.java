public class Problem240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int rows = matrix.length, cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            int[] row = matrix[i];
            if (row[0] <= target && target <= row[cols-1]) {
                if (binarySearch(row, 0, cols-1, target)) return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        if (nums[mid] == target) return true;
        else if (nums[mid] > target) return binarySearch(nums, lo, mid - 1, target);
        else return binarySearch(nums, mid + 1, hi, target);
    }
}
