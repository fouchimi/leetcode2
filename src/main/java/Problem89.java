import java.util.ArrayList;
import java.util.List;

public class Problem89 {

    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>();
        if(n == 0) {
            ans.add(0);
            return ans;
        }

        List<Integer> part1 = grayCode(n - 1);
        List<Integer> part2 = new ArrayList<>();
        int high = (int)Math.pow(2, n - 1);
        for(int i = part1.size() - 1; i >= 0; i--) {
            part2.add(high + part1.get(i));
        }

        ans.addAll(part1);
        ans.addAll(part2);
        return ans;
    }

    public static void main(String[] args) {
        Problem89 problem89 = new Problem89();
        System.out.println(problem89.grayCode(2));
    }
}
