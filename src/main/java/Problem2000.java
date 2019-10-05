import java.util.ArrayList;
import java.util.List;

public class Problem2000 {
    public int maxNumber(int num) {
        List<Integer> l = new ArrayList<>();
        int sign = num < 0 ? -1 : 1;
        num = Math.abs(num);

        while (num > 0) {
            int r = num % 10;
            l.add(0, r);
            num /= 10;
        }

        int index = 0;
        if (sign > 0) while (index < l.size() && l.get(index) > 5) {
            index++;
        }
        else while (index < l.size() && l.get(index) < 5) index++;
        l.add(index, 5);

        int result = 0;
        while (!l.isEmpty()) result = 10*result + l.remove(0);
        return sign * result;
    }

    public static void main(String[] args) {
        Problem2000 problem2000 = new Problem2000();
        System.out.println(problem2000.maxNumber(268));
        System.out.println(problem2000.maxNumber(668));
        System.out.println(problem2000.maxNumber(-13));
        System.out.println(problem2000.maxNumber(-31));
        System.out.println(problem2000.maxNumber(-669));
    }
}
