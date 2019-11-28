public class Problem66 {
    public int[] plusOne (int[] digits) {
        if (digits == null || digits.length == 0) return new int[]{0};
        int i = digits.length - 1, sum = 0, val = 1;
        while (i >= 0) {
            sum += digits[i] + val;
            digits[i] = sum % 10;
            sum /= 10;
            i--;
            val = 0;
        }
        if (sum == 0) return digits;
        else  {
            int[] res = new int[digits.length + 1];
            for (int j = digits.length - 1; j >= 0; j--) res[j] = digits[j];
            res[0] = sum;
            return res;
        }
    }

    public static void main(String[] args) {
        Problem66 problem66 = new Problem66();
        int[] digits = {4,3,2,1};
        int[] res = problem66.plusOne(digits);
        for (int val : res) {
            System.out.print(val + " ");
        }
    }
}
