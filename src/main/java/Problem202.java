import java.util.HashMap;
import java.util.Map;

public class Problem202 {
    public boolean isHappy(int n) {
        Map<Integer, Boolean> used = new HashMap<>();
        return isHappyUtil(n, used);
    }

    private boolean isHappyUtil(int n, Map<Integer, Boolean> used) {
        if (n == 1) return true;
        if (used.get(n) != null && used.get(n)) return false;
        used.put(n, true);
        int sum = 0;
        while (n > 0) {
            int r = n % 10;
            sum += square(r);
            n /= 10;
        }
        return isHappyUtil(sum, used);
    }

    private int square(int val) {
        return val * val;
    }

    public static void main(String[] args) {
        Problem202 problem202 = new Problem202();
        System.out.println(problem202.isHappy(2));
        System.out.println(problem202.isHappy(19));
        System.out.println(problem202.isHappy(7));
    }
}
