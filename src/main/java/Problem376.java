public class Problem376 {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int max, tmp = nums[0], i = 1;
        // This line will skipped all nums equals to nums[0]
        while (i < nums.length && nums[i] == nums[0]) i++;
        // If i == nums.length the max length is 1
        if (i == nums.length) return 1;
        // Important to have a boolean to know if the sequence start with a negative or positive difference
        boolean flag = nums[i] > tmp;
        max = 2;
        tmp = nums[i++];
        // We only update max when we have a valid wiggle sequence below
        for(; i < nums.length; i++){
            if (flag) {
                if (nums[i] < tmp) {
                    max++;
                    flag = false;
                }
            } else {
                if (nums[i] > tmp) {
                    max++;
                    flag = true;
                }
            }
            tmp = nums[i];
        }
        return max;
    }

    public static void main(String[] args) {
        Problem376 problem376 = new Problem376();
        System.out.println(problem376.wiggleMaxLength(new int[]{1, 7, 4, 9, 2, 5}));
        System.out.println(problem376.wiggleMaxLength(new int[]{1, 17, 5, 10, 13, 15, 10, 5, 16, 8}));
        System.out.println(problem376.wiggleMaxLength(new int[]{1, 4, 7, 2, 5}));
        System.out.println(problem376.wiggleMaxLength(new int[]{1, 7, 4, 5, 5}));
    }
}
