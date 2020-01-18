public class Problem1317 {
    public int[] getNoZeroIntegers(int n) {
        int i = 1;
        for (; i < n; i++) {
            if (isNoZero(i) || isNoZero(n-i)) continue;
            else break;
        }
        int[] res = new int[2];
        res[0] = i;
        res[1] = n-i;
        return res;
    }

    private boolean isNoZero(int num) {
        while (num > 0) {
            int r = num % 10;
            if (r == 0) return true;
            num /= 10;
        }
        return false;
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1317 problem1317 = new Problem1317();
        problem1317.print(problem1317.getNoZeroIntegers(2));
        problem1317.print(problem1317.getNoZeroIntegers(1010));
        problem1317.print(problem1317.getNoZeroIntegers(11));
        problem1317.print(problem1317.getNoZeroIntegers(10000));
        problem1317.print(problem1317.getNoZeroIntegers(69));

    }
}
