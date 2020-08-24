public class Problem665 {
    public boolean checkPossibility(int[] nums) {
        int end = 1, N = nums.length;
        while (end < N  && nums[end - 1] <= nums[end]) end++;
        if (end == N) return true;
        int prev = nums[end - 1];
        nums[end - 1] = nums[end];
        int temp = 1;
        while (temp < N && nums[temp - 1] <= nums[temp]) temp++;
        if (temp == N) return true;
        nums[end - 1] = prev;
        nums[end] = nums[end - 1];
        temp = 1;
        while (temp < N && nums[temp - 1] <= nums[temp]) temp++;
        return temp == N;
    }

    public static void main(String[] args) {
        Problem665 problem665 = new Problem665();
        System.out.println(problem665.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(problem665.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(problem665.checkPossibility(new int[]{5, 7, 1, 8}));
        System.out.println(problem665.checkPossibility(new int[]{-1, 4, 2, 3}));
        System.out.println(problem665.checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
