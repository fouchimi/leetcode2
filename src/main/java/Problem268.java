import java.util.Arrays;

public class Problem268 {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > count) return count;
            count++;
        }
        return nums.length;
    }

    public static void main(String[] args) {
        Problem268 problem268 = new Problem268();
        int[] nums = {3,0,1};
        System.out.println(problem268.missingNumber(nums));
    }
}
