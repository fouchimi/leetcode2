public class Problem153 {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int i = 1;
        while (i < nums.length && nums[i-1] <= nums[i]) i++;
        if (i == nums.length) return nums[0];
        return Math.min(Math.min(nums[0], nums[i-1]), Math.min(nums[i], nums[nums.length-1]));
    }

    public static void main(String[] args) {
        Problem153 problem153 = new Problem153();
        int[] nums = {1, 2};
        System.out.println(problem153.findMin(nums));
    }
}
