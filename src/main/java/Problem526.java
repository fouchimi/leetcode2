import java.util.ArrayList;
import java.util.List;

public class Problem526 {
    public int countArrangement(int N) {
        int[] dp = new int[1];
        boolean[] visited = new boolean[N + 1];
        helper(N, new ArrayList<>(), visited, dp, 1);
        return dp[0];
    }

    private void helper(int N, List<Integer> list, boolean[] visited, int[] dp, int index) {
        if (list.size() == N) {
            dp[0]++;
            return;
        }

        for (int i = 1; i <= N; i++) {
           if (visited[i] || (i % index != 0 && index % i != 0)) continue;
           list.add(i);
           visited[i] = true;
           helper(N, list, visited, dp, index + 1);
           visited[i] = false;
           list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Problem526 problem526 = new Problem526();
        // System.out.println(problem526.countArrangement(2));
        System.out.println(problem526.countArrangement(3));
    }
}
