import java.util.LinkedHashMap;
import java.util.Map;

public class Problem1400 {

    public int[] sortedSquares(int[] A) {
        int[] ans = new int[A.length];
        int i = 0;

        while (i < A.length && A[i] < 0) i++;

        int j = i, index = 0;

        while (j >= 0 && i < A.length) {
            if (A[j] * A[j] < A[i] * A[i]) {
                ans[index] = A[j] * A[j];
                j--;
            } else {
                ans[index] = A[i] * A[i];
                i++;
            }
            index++;
        }

        while(j >= 0) {
            ans[index] = A[j] * A[j];
            j--;
            index++;
        }

        while(i < A.length) {
            ans[index] = A[i] * A[i];
            i++;
            index++;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
