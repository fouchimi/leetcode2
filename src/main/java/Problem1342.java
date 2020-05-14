public class Problem1342 {

    public int numberOfSteps (int num) {
        if (num == 0) return 0;
        return (num % 2 == 0) ? 1 + numberOfSteps(num / 2) : 1 + numberOfSteps(num - 1);
    }

    public static void main(String[] args) {
        Problem1342 problem1342 = new Problem1342();
        System.out.println(problem1342.numberOfSteps(14));
    }
}
