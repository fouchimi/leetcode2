public class Problem231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        else if (n == 1) return true;
        else if (n % 2 == 0) return isPowerOfTwo(n/2);
        else return false;
    }

    public static void main(String[] args) {
        Problem231 problem231 = new Problem231();
        System.out.println(problem231.isPowerOfTwo(16));
        System.out.println(problem231.isPowerOfTwo(14));
    }
}
