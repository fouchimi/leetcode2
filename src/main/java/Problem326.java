public class Problem326 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        else if (n == 1) return true;
        else if (n % 3 == 0) return isPowerOfThree(n / 3);
        else return false;
    }

    public static void main(String[] args) {
        Problem326 problem326 = new Problem326();
        System.out.println(problem326.isPowerOfThree(27));
        System.out.println(problem326.isPowerOfThree(0));
        System.out.println(problem326.isPowerOfThree(45));
    }
}
