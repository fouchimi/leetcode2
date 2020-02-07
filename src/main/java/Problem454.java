import java.util.HashMap;
import java.util.Map;

public class Problem454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0, N = A.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int key = A[i] + B[j];
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int key = -(C[i] + D[j]);
                if (map.containsKey(key)) count += map.get(key);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Problem454 problem454 = new Problem454();
        System.out.println(problem454.fourSumCount(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
        System.out.println(problem454.fourSumCount(new int[]{0, 1, -1}, new int[]{-1, 1, 0}, new int[]{0, 0, 1}, new int[]{-1, 1, 1}));
    }

}
