public class Problem1492 {
    public int kthFactor(int n, int k) {
        if (k > n) return -1;
        int div = 1;
        while (k > 0 && div <= n) {
            while (div <= n && k > 0) {
                if (n % div == 0) k--;
                if (k == 0) break;
                div++;
            }
        }
        return k == 0 ? div : -1;
    }

    public static void main(String[] args) {
        Problem1492 problem1492 = new Problem1492();
        System.out.println(problem1492.kthFactor(12, 3));
        System.out.println(problem1492.kthFactor(7, 2));
        System.out.println(problem1492.kthFactor(4, 4));
        System.out.println(problem1492.kthFactor(1, 1));
        System.out.println(problem1492.kthFactor(1000, 3));
    }
}
