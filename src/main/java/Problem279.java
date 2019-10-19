import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem279 {
    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        int level = 0;
        Set<Integer> visited = new HashSet<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                if(q.isEmpty()) break;
                int m = q.poll();
                for(int j = 1; j*j <= m; j++) {
                    int val = m - j*j;
                    if(val == 0) return level+1;
                    if(!visited.contains(val)) {
                        q.offer(val);
                        visited.add(val);
                    }
                }
            }
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem279 problem279 = new Problem279();
        System.out.println(problem279.numSquares(12));
    }
}
