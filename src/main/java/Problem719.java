import java.util.Arrays;

public class Problem719 {

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0, high = nums[n - 1] - nums[0];
        while (low < high) {
            int cnt = 0, left = 0;
            int mid = (low + high) / 2;

            for (int right = 0; right < n; right++) {
                while (nums[right] - nums[left] > mid) left++;
                cnt += right - left;
            }

            if (cnt >= k) high = mid;
            else low = mid + 1;
        }
        return low;
    }


    public static void main(String[] args) {
        Problem719 problem719 = new Problem719();
        System.out.println(problem719.smallestDistancePair(new int[]{1, 3, 1}, 1));
    }
}
