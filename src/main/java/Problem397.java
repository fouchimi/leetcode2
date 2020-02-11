public class Problem397 {
    public int integerReplacement(int n) {
        long value = n;
        return (int) helper((value));
    }

    private long helper(long n) {
        if (n <= 1) return 0;
        return n % 2 == 0 ? 1 + helper(n/2) : 1 + Math.min(helper(n + 1), helper(n - 1));
    }

    public static void main(String[] args) {
        Problem397 problem397 = new Problem397();
        System.out.println(problem397.integerReplacement(8));
        System.out.println(problem397.integerReplacement(7));
        System.out.println(problem397.integerReplacement(2147483647));
    }
}
