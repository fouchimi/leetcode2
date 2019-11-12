public class Problem29 {
    public int divide(int dividend, int divisor) {
        int sign  = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1 : -1;
        long dividendPos = Math.abs((long) dividend), divisorPos = Math.abs((long) divisor);
        long result = sign * helper(dividendPos, divisorPos);
        return result > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) result;
    }

    private long helper(long dividend, long divisor) {
        long result = 0;
        while (dividend >= divisor) {
            long multiple = 1, sum = divisor;
            while (sum + sum <= dividend) {
                multiple += multiple;
                sum += sum;
            }
            result += multiple;
            dividend -= sum;
        }
        return result;
    }

    public static void main(String[] args) {
        Problem29 problem29 = new Problem29();
        System.out.println(problem29.divide(7, -3));
        System.out.println(problem29.divide(2147483647, 2));
    }
}
