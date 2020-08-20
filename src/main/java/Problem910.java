import java.util.Arrays;

public class Problem910 {
    public int smallestRangeII(int[] A, int K) {
        if (A.length == 0 || A.length == 1) return 0;
        Arrays.sort(A);
        int N = A.length;
        int left = A[0] + K, right = A[N - 1] - K;
        int res = A[N - 1] - A[0];
        for (int i = 0; i < N - 1; i++) {
            int min = Math.min(left, A[i + 1] - K);
            int max = Math.max(right, A[i] + K);
            res = Math.min(res, max - min);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem910 problem910 = new Problem910();
        System.out.println(problem910.smallestRangeII(new int[]{10, 7, 1}, 3));
        System.out.println(problem910.smallestRangeII(new int[]{0, 10}, 2));
        System.out.println(problem910.smallestRangeII(new int[]{7, 8, 8}, 5));
        System.out.println(problem910.smallestRangeII(new int[]{5, 6, 4}, 5));
        System.out.println(problem910.smallestRangeII(new int[]{1, 3, 6}, 3));
    }
}
