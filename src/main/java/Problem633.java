public class Problem633 {

    public boolean judgeSquareSum(int c) {
        int a = 0, b = (int) Math.sqrt(c);
        while (a <= b) {
            int sum = a * a + b * b;
            if (sum == c) return true;
            else if (sum > c) b--;
            else a++;
        }
        return false;
    }


    public static void main(String[] args) {
        Problem633 problem633 = new Problem633();
        System.out.println(problem633.judgeSquareSum(8));
        System.out.println(problem633.judgeSquareSum(4));
        System.out.println(problem633.judgeSquareSum(5));
        System.out.println(problem633.judgeSquareSum(3));
    }
}
