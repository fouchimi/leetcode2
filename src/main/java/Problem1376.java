import java.util.ArrayList;
import java.util.List;

public class Problem1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<Integer>[] map = new ArrayList[n];
        for (int i = 0; i < n; i++) map[i] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int head = manager[i];
            if (head == -1) continue;
            map[head].add(i);
        }
        int[] maxTime = new int[1];
        dfs(headID, map, informTime, 0, maxTime);
        return maxTime[0];
    }

    private void dfs(int s, List<Integer>[] map, int[] informTime, int sum, int[] maxTime) {
        if (map[s].size() == 0) {
            maxTime[0] = Math.max(maxTime[0], sum);
            return;
        }
        for (Integer subordinate : map[s]) {
            dfs(subordinate, map, informTime, sum + informTime[s], maxTime);
        }
    }

    public static void main(String[] args) {
        Problem1376 problem1376 = new Problem1376();
        System.out.println(problem1376.numOfMinutes(1, 0, new int[]{-1}, new int[]{0}));
        System.out.println(problem1376.numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0}));
        System.out.println(problem1376.numOfMinutes(7, 6, new int[]{1, 2, 3, 4, 5, 6, -1}, new int[]{0, 6, 5, 4, 3, 2, 1}));
        System.out.println(problem1376.numOfMinutes(15, 0, new int[]{-1,0,0,1,1,2,2,3,3,4,4,5,5,6,6}, new int[]{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0}));
        System.out.println(problem1376.numOfMinutes(8, 0, new int[]{-1, 5, 0, 6, 7, 0 , 0, 0}, new int[]{89, 0, 0, 0, 0, 523, 241, 519}));
    }
}
