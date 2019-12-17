public class Problem96 {
    public int numTrees(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            int res = 0, mid = n / 2;
            if (n % 2 == 0) {
                for (int i = 0; i <= mid - 1; i++) {
                    res += n - 1;
                    n--;
                }
                return 2 * res;
            } else {
                for (int i = 0; i < mid; i++) {
                    res += n - 1;
                    n--;
                }
                return 2 * res + 1;
            }
        }
    }

    public static void main(String[] args) {
        Problem96 problem96 = new Problem96();
        System.out.println(problem96.numTrees(3));
        System.out.println(problem96.numTrees(4));
    }
}
