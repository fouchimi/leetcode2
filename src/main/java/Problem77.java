import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Problem77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        combineUtil(n, k, new ArrayList<>(), res, visited);
        return res;
    }

    private void combineUtil(int n, int k, List<Integer> list, List<List<Integer>> res, boolean[] visited) {
        if (list.size() == k) {
            ArrayList<Integer> temp = new ArrayList<>(list);
            res.add(temp);
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] || (!list.isEmpty() && i < list.get(list.size()-1))) continue;
            list.add(i);
            visited[i] = true;
            combineUtil(n, k, list, res, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Problem77 problem77 = new Problem77();
        List<List<Integer>> res = problem77.combine(4, 2);
        for(List<Integer> l : res) System.out.println(l);
    }
}
