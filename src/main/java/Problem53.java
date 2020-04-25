public class Problem53 {

    public int maxSubArray(int[] nums) {
        return maxSubArrayUtil(nums, 0, nums.length - 1);
    }

    private int maxSubArrayUtil(int[] nums, int p, int r) {
        if (r == p) return nums[p];
        int mid = p + (r - p) / 2;
        int left = maxSubArrayUtil(nums, p, mid);
        int right = maxSubArrayUtil(nums, mid + 1, r);
        int center = maxCrossingArrayUtil(nums, p, mid, r);
        return Math.max(left, Math.max(right, center));
    }

    public int maxCrossingArrayUtil(int[] arr, int startIndex, int mid, int endIndex) {
        int maxLeftSum = arr[mid];
        int currentSum = maxLeftSum;
        for (int i = mid - 1; i >= startIndex; i--) {
            currentSum += arr[i];
            maxLeftSum = Math.max(maxLeftSum, currentSum);
        }
        int maxRightSum = arr[mid + 1];
        currentSum = maxRightSum;
        for (int i = mid + 2; i <= endIndex; i++) {
            currentSum +=arr[i];
            maxRightSum = Math.max(maxRightSum, currentSum);
        }
        return maxLeftSum + maxRightSum;
    }

    public static void main(String[] args) {
        Problem53 problem53 = new Problem53();
        System.out.println(problem53.maxSubArray(new int[]{-1, 3, 4, -5, 9, -2}));
    }
}
