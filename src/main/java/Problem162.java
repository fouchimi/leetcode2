public class Problem162 {

    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int[] res = new int[nums.length + 2];
        res[0] = Integer.MIN_VALUE;
        res[res.length - 1] = Integer.MIN_VALUE;

        for (int i = 1; i < res.length - 1; i++) res[i] = nums[i-1];

        for (int i = 1; i < res.length - 1; i++) {
            if (res[i-1] < res[i] && res[i] > res[i + 1]) return i - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem162 problem162 = new Problem162();
        System.out.println(problem162.findPeakElement(new int[]{1,2,3,1}));
        System.out.println(problem162.findPeakElement(new int[]{1,2,1,3,5,6,4}));
    }
}
