public class Problem26 {
    public int removeDuplicates(int[] nums) {
        int start = 0, N = nums.length;
        while (start < N) {
            int end = start, count = 0;
            while (end < N && nums[start] == nums[end]) {
                end++;
                count++;
            }
            while (count > 1) {
                for (int j = start + 1; j < nums.length; j++) nums[j-1] = nums[j];
                nums[nums.length - 1] = '\0';
                N--;
                count--;
            }
            start++;
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        return N;
    }

    public static void main(String[] args) {
        Problem26 problem26 = new Problem26();
        int[] nums = {1,1,2};
        problem26.removeDuplicates(nums);
    }
}
