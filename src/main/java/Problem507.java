public class Problem507 {
    public boolean checkPerfectNumber(int num) {
        if (num == 0 || num == 1) return false;
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        Problem507 problem507 = new Problem507();
        System.out.println(problem507.checkPerfectNumber(6));
        System.out.println(problem507.checkPerfectNumber(28));
    }
}
