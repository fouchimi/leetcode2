import java.util.Arrays;

public class Problem1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int N = nums.length;
        int[] target = new int[N];
        Arrays.fill(target, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            if (target[index[i]] != Integer.MIN_VALUE) {
                for (int j = N - 1; j > index[i]; j--) {
                    target[j] = target[j - 1];
                }
            }
            target[index[i]] = nums[i];
        }
        return target;
    }

    public static void main(String[] args) {
        Problem1389 problem1389 = new Problem1389();
        int[] result = problem1389.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}
