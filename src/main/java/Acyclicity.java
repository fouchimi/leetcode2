import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Acyclicity {
    private static int acyclic(ArrayList<Integer>[] adj) {
        int V = adj.length;
        int[] inDegrees = new int[V];
        for(int v = 0; v < V; v++) {
            for(int u : adj[v]) inDegrees[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int v = 0; v < V; v++) {
            if(inDegrees[v] == 0) q.offer(v);
        }
        if(q.isEmpty()) return 1;
        int count = 0;
        while(!q.isEmpty()) {
            int u = q.poll();
            for(int w : adj[u]) {
                if(--inDegrees[w] == 0) q.offer(w);
            }
            count++;
        }
        return count < V ? 1 : 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(acyclic(adj));
    }
}

