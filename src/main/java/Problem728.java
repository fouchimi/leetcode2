import java.util.ArrayList;
import java.util.List;

public class Problem728 {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int old = i;
            while (old > 0) {
                int r = old % 10;
                if (r == 0) break;
                if (i % r == 0) old /= 10;
                else break;
            }
            if (old == 0) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem728 problem728 = new Problem728();
        System.out.println(problem728.selfDividingNumbers(1, 22));
    }
}
