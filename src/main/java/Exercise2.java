import java.util.HashMap;
import java.util.Map;

public class Exercise2 {
    Map<Integer, Integer> memo = new HashMap<>();
    private int numJars(int N, int C) {
        if (N <= C) return 1;
        if (memo.containsKey(N)) return memo.get(N);
        int half = N / 2;
        int otherHalf = N % half != 0 ? half + 1 : half;
        int left = numJars(half, C);
        int right = numJars(otherHalf, C);
        memo.put(N, left + right);
        return memo.get(N);
    }

    public static void main(String[] args) {

    }
}
