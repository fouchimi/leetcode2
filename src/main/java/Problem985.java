import java.util.Arrays;

public class Problem985 {

    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] result = new int[A.length];
        int sumEven = 0;
        for(int val : A) {
            if(val % 2 == 0) sumEven += val;
        }

        for(int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if(A[query[1]] % 2 == 0) sumEven -= A[query[1]];
            A[query[1]] += query[0];
            if(A[query[1]] % 2 == 0) sumEven += A[query[1]];
            result[i] = sumEven;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem985 problem985 = new Problem985();
        int[] A = {1,2,3,4};
        int[][] queries = {{1,0},{-3,1},{-4,0},{2,3}};

        Arrays.stream(problem985.sumEvenAfterQueries(A, queries)).forEach(System.out::println);

    }
}
