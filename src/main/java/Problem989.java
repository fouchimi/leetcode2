import java.util.ArrayList;
import java.util.List;

public class Problem989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> result = new ArrayList<>();
        int index = A.length - 1, sum = 0;

        while (K > 0 && index >= 0) {
            int r = K % 10;
            K /= 10;
            sum += A[index] + r;
            result.add(0, sum % 10);
            sum /= 10;
            index--;
        }

        while (index >= 0) {
            sum += A[index];
            result.add(0, sum % 10);
            sum /= 10;
            index--;
        }

        while (K > 0) {
            int r = K % 10;
            sum += r;
            result.add(0, sum % 10);
            K /= 10;
            sum /= 10;
        }

        if(sum > 0) result.add(0, sum);
        return result;
    }

    public static void main(String[] args) {
        Problem989 problem989 = new Problem989();
        int[] A = {6};
        problem989.addToArrayForm(A, 809).forEach(System.out::print);
    }
}
