
public class Problem45 {

//    public int jump(int[] nums) {
//        int len = nums.length;
//        if (len == 0 || len == 1)
//            return 0;
//
//        int current = 0, to = 0, maxTo = 0, steps = 0;
//
//        while (current <= to) {
//            steps++;
//            while (current <= to) {
//                maxTo = Math.max(maxTo, nums[current] + current);
//                if (maxTo >= len-1) return steps;
//                current++;
//            }
//            to = maxTo;
//        }
//
//        return -1;
//    }

    public int jump(int[] nums) {
        if (nums.length == 1) return 0;
        int count = 0, i = 0;
        while (i + nums[i] < nums.length - 1) {
            int maxVal = 0, maxValIndex = 0;
            for (int j = 1; j <= nums[i]; j++) {
                if (nums[j + i] + j > maxVal) {
                    maxVal = nums[j + i] + j;
                    maxValIndex = i + j;
                }
            }
            i = maxValIndex;
            count++;
        }
        return count + 1;
    }

    public static void main(String[] args) {
        Problem45 problem45 = new Problem45();
        int[] nums = new int[] {2, 3, 1, 1, 4};
        System.out.println(problem45.jump(nums));
        System.out.println(problem45.jump(new int[]{1, 2}));
        System.out.println(problem45.jump(new int[]{3, 2, 1}));
        System.out.println(problem45.jump(new int[]{1, 1, 1, 1}));
    }
}
