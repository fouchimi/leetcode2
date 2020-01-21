public class Problem172 {
    public int trailingZeroes(int n) {
        int numberOfFives = 0;
        while (n >= 5) {
            numberOfFives += (int) Math.floor(n / 5.0);
            n = (int) Math.floor(n / 5.0);
        }
        return numberOfFives;
    }

    public static void main(String[] args) {
        Problem172 problem172 = new Problem172();
        System.out.println(problem172.trailingZeroes(3));
        System.out.println(problem172.trailingZeroes(5));
        System.out.println(problem172.trailingZeroes(13));
        System.out.println(problem172.trailingZeroes(30));
    }
}
