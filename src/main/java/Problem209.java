public class Problem209 {

    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int windowStart = 0, windowEnd = 0, currentRunningSum = 0, min = Integer.MAX_VALUE;
        for (; windowEnd < nums.length; ) {
            while (currentRunningSum < s && windowEnd < nums.length) {
                currentRunningSum += nums[windowEnd];
                windowEnd++;
            }
            while (currentRunningSum >= s) {
                if (windowEnd - windowStart  < min) {
                    min = windowEnd - windowStart;
                }
                currentRunningSum -= nums[windowStart];
                windowStart++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        Problem209 problem209 = new Problem209();
        System.out.println(problem209.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(problem209.minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }
}
