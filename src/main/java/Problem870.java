import java.util.*;

public class Problem870 {
    public int[] advantageCount(int[] A, int[] B) {
        Queue<Integer> heapA = new PriorityQueue<>((i, j) -> A[j] - A[i]);
        Queue<Integer> heapB = new PriorityQueue<>((i, j) -> B[j] - B[i]);

        int N = A.length;
        int[] res = new int[N];

        for (int i = 0; i < N; i++) {
            heapA.add(i);
            heapB.add(i);
        }

        Set<Integer> nonAdvantageIndices = new HashSet<>();
        while (!heapB.isEmpty() && !heapA.isEmpty()) {
            if (A[heapA.peek()] > B[heapB.peek()]) {
                res[heapB.poll()] = A[heapA.poll()];
            } else {
                nonAdvantageIndices.add(heapB.poll());
            }
        }

        nonAdvantageIndices.forEach(i -> res[i] = A[heapA.poll()]);

        return res;
    }

    private void print (int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem870 problem870 = new Problem870();
        int[] res = problem870.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11});
        problem870.print(res);

        res = problem870.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11});
        problem870.print(res);

        res = problem870.advantageCount(new int[]{2, 0, 4, 1, 2}, new int[]{1, 3, 0, 0, 2});
        problem870.print(res);

        res = problem870.advantageCount(new int[]{15448,14234,13574,19893,6475}, new int[]{14234,6475,19893,15448,13574});
        problem870.print(res);
    }
}
