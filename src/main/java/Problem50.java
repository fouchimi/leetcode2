
public class Problem50 {
    double myPow(double x, int n) {
        if (n == 0) {return 1.0; }
        if (n == 1) { return x; };
        if (n == -1) {return 1/x; };
        double halfPow = myPow(x, n / 2);
        if (n % 2 == 0) return halfPow * halfPow;
        if (n > 0) {
            return halfPow * halfPow *x;
        }
        return halfPow * halfPow * 1/x;
    }

    public static void main(String[] args) {
        Problem50 problem50 = new Problem50();
        System.out.println(problem50.myPow(2.0000, 10));
    }
}
