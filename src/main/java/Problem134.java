public class Problem134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int p = 0, length = gas.length;
        while (p < length) {
            while (p < length && gas[p] < cost[p]) p++;
            int q = p % length;
            int sum = gas[q], N = 0;
            while (N < length) {
                int currentIndex = (q % length), nextIndex = (q + 1) % length;
                sum = sum - cost[currentIndex] + gas[nextIndex];
                if (sum < gas[nextIndex]) break;
                N++;
                q = nextIndex;
            }
            if (N == gas.length) return q;
            p++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Problem134 problem134 = new Problem134();
        int[] gas = {4,5,2,6,5,3};
        int[] cost = {3,2,7,3,2,9};
        System.out.println(problem134.canCompleteCircuit(gas, cost));
    }
}
