public class Problem1015 {
    public int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int r = 0;
        for (int N = 1; N <= K; ++N) {
            r = (r * 10 + 1) % K;
            if (r == 0) return N;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem1015 problem1015 = new Problem1015();
        System.out.println(problem1015.smallestRepunitDivByK(1));
        System.out.println(problem1015.smallestRepunitDivByK(2));
        System.out.println(problem1015.smallestRepunitDivByK(3));
        System.out.println(problem1015.smallestRepunitDivByK(17));
        System.out.println(problem1015.smallestRepunitDivByK(23));
    }
}
