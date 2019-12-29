public class Problem258 {
    public int addDigits(int num) {
        if (num < 10) return num;
        int sum = 0;
        while (num > 0) {
            int r = num % 10;
            sum += r;
            num /= 10;
        }
        return addDigits(sum);
    }

    public static void main(String[] args) {
        Problem258 problem258 = new Problem258();
        System.out.println(problem258.addDigits(38));
    }
}
