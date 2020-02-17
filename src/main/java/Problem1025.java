public class Problem1025 {
    public boolean divisorGame(int N) {
        boolean[] res = new boolean[N + 1];
        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= i/2; j++) {
                if (i % j == 0 && !res[i-j]) {
                    res[i] = true;
                    break;
                }
            }
        }
        return res[N];
    }

    public static void main(String[] args) {
        Problem1025 problem1025 = new Problem1025();
        System.out.println(problem1025.divisorGame(4));
        System.out.println(problem1025.divisorGame(3));
        System.out.println(problem1025.divisorGame(2));
        System.out.println(problem1025.divisorGame(9));
    }
}
