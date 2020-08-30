import java.util.ArrayList;
import java.util.List;

public class Problem89 {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        int[] arr = new int[n];
        helper(n, arr, ans, 0, false);
        return ans;
    }

    private void helper(int n, int[] arr, List<Integer> ans, int index, boolean flag) {
        if (index == n) {
            ans.add(convertToDecimal(arr));
            return;
        }
        if (!flag) {
            arr[index] = 0;
            helper(n, arr, ans, index + 1, false);
            arr[index] = 1;
            helper(n, arr, ans, index + 1, true);
        } else {
            arr[index] = 1;
            helper(n, arr, ans, index + 1, false);
            arr[index] = 0;
            helper(n, arr, ans, index + 1, true);
        }
    }

    private int convertToDecimal(int[] arr) {
        int result = 0, base = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            result += arr[i] * base;
            base *= 2;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem89 problem89 = new Problem89();
        System.out.println(problem89.grayCode(2));
    }
}
