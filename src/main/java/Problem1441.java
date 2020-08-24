import java.util.ArrayList;
import java.util.List;

public class Problem1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int index = 0;
        for(int i = 1; i <= n; i++) {
            if (index == target.length) break;
            if (target[index] == i) {
                index++;
                ans.add("Push");
            }
            else {
                ans.add("Push");
                ans.add("Pop");
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem1441 problem1441 = new Problem1441();
        System.out.println(problem1441.buildArray(new int[]{1, 3}, 3));
        System.out.println(problem1441.buildArray(new int[]{1, 2, 3}, 3));
        System.out.println(problem1441.buildArray(new int[]{1, 2}, 4));
    }
}
