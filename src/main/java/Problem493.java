import java.util.Arrays;

public class Problem493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end) return 0;
        int mid = start + (end - start) / 2;
        int cnt = mergeSort(nums, start, mid) +
                mergeSort(nums, mid + 1, end);
        for (int i = start, j = mid + 1; i <= mid; i++) {
            while (j <= end && nums[i]/2.0 > nums[j]) j++;
            cnt += j - (mid + 1);
        }
        Arrays.sort(nums, start, end + 1);
        return cnt;
    }

    public static void main(String[] args) {
        Problem493 problem493 = new Problem493();
        System.out.println(problem493.reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
