public class Problem342 {
    public boolean isPowerOfFour(int num) {
        if (num == 0) return false;
        else if (num == 1) return true;
        else if (num % 4 == 0) return isPowerOfFour(num / 4);
        else return false;
    }

    public static void main(String[] args) {
        Problem342 problem342 = new Problem342();
        System.out.println(problem342.isPowerOfFour(16));
        System.out.println(problem342.isPowerOfFour(42));
    }
}
