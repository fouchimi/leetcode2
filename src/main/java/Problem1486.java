public class Problem1486 {
    public int xorOperation(int n, int start) {
        int res = 0, i = 0;
        while (n > 0) {
            res = res ^ (start + 2 * i);
            i++;
            n--;
        }
        return res;
    }

    public static void main(String[] args) {
        Problem1486 problem1486 = new Problem1486();
        System.out.println(problem1486.xorOperation(5, 0));
        System.out.println(problem1486.xorOperation(4, 3));
        System.out.println(problem1486.xorOperation(1, 7));
        System.out.println(problem1486.xorOperation(10, 5));
    }
}
