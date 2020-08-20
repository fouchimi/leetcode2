import java.util.ArrayList;
import java.util.List;

public class Problem932 {

    public int[] beautifulArray(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) list.add(i);
        List<Integer> res = dfs(list);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private List<Integer> dfs(List<Integer> l) {
        if (l.size() < 3) return l;
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();
        for (int i = 0; i < l.size(); ++i) {
            if (i % 2 == 0) even.add(l.get(i));
            else odd.add(l.get(i));
        }

        odd = dfs(odd);
        even = dfs(even);

        List<Integer> temp = new ArrayList<>();
        temp.addAll(even);
        temp.addAll(odd);

        return temp;
    }

    public static void main(String[] args) {
        Problem932 problem932 = new Problem932();
        problem932.beautifulArray(4);
        problem932.beautifulArray(5);
    }
}
