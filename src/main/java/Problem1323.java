import java.util.ArrayList;
import java.util.List;

public class Problem1323 {
    public int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        int max = num;
        while (num > 0) {
            int r = num % 10;
            num /= 10;
            list.add(0, r);
        }

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 6) {
                max = Math.max(max, helper(list, i, 9));
            } else  {
                max = Math.max(max, helper(list, i, 6));
            }
        }

        return max;
    }

    private int helper(List<Integer> list, int index, int _6_9) {
        int ans = 0;
        for (int i = 0; i  < list.size(); i++) {
            if (i == index) {
                ans = 10 * ans + _6_9;
            } else {
                ans = 10 * ans + list.get(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem1323 problem1323 = new Problem1323();
        System.out.println(problem1323.maximum69Number(9669));
    }
}
