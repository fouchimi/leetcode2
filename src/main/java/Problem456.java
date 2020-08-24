import java.util.Stack;

public class Problem456 {

    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        int N = nums.length, min = nums[0];
        int[] left = new int[N];
        left[0] = min;
        for (int i = 1; i < N; i++) {
            left[i] = min;
            min = Math.min(min, nums[i]);
        }
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (nums[j] > left[i] && nums[i] > nums[j]) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem456 problem456 = new Problem456();
        System.out.println(problem456.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(problem456.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(problem456.find132pattern(new int[]{-1, 3, 2, 0}));
        System.out.println(problem456.find132pattern(new int[]{3, 5, 0, 3, 4}));
        System.out.println(problem456.find132pattern(new int[]{-2, 1, 1}));
        System.out.println(problem456.find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));
    }
}
