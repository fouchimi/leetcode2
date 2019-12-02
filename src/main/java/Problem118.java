
import java.util.*;

public class Problem118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0 || numRows < 0) return res;
        else if (numRows == 1) {
            return Collections.singletonList(Collections.singletonList(1));
        }
        else if (numRows == 2) {
            return Arrays.asList(Collections.singletonList(1), Arrays.asList(1, 1));
        } else {
            res.add(Collections.singletonList(1));
            res.add(Arrays.asList(1, 1));
            int k = numRows - 2;
            while (k > 0) {
                List<Integer> last = res.get(res.size() - 1);
                List<Integer> newList = new ArrayList<>();
                newList.add(1);
                for (int i = 1; i < last.size(); i++) {
                    newList.add(last.get(i-1) + last.get(i));
                }
                newList.add(1);
                res.add(newList);
                k--;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        Problem118 problem118 = new Problem118();
        List<List<Integer>> resultList = problem118.generate(5);
        for (List<Integer> list : resultList) {
            System.out.println(list);
        }
    }
}
