import java.util.Arrays;
import java.util.PriorityQueue;

public class Problem977 {

    public int[] sortedSquares(int[] A) {
       for(int i = 0; i < A.length; i++) A[i] *= A[i];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a-b);
        for(int i = 0; i < A.length; i++) pq.offer(A[i]);
        int[] result = new int[A.length];
        int index = 0;
        while (!pq.isEmpty()) {
            result[index++] = pq.poll();
        }
      return result;
    }

    public static void main(String[] args) {
        Problem977 problem977 = new Problem977();
        int[] A = {-7,-3,2,3,11};
        Arrays.stream(problem977.sortedSquares(A)).forEach(System.out::print);
    }
}
