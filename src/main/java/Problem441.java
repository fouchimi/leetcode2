
public class Problem441 {

    public int arrangeCoins(int n) {
        return helper(n, 1);
    }

    private int helper(int n, int count) {
        if (count > n) return 0;
        return 1 + helper(n - count, count + 1);
    }

    public static void main(String[] args) {
        Problem441 problem441 = new Problem441();
        System.out.println(problem441.arrangeCoins(3));
        System.out.println(problem441.arrangeCoins(5));
        System.out.println(problem441.arrangeCoins(8));
    }
}
