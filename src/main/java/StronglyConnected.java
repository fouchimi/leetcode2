import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;

public class StronglyConnected {
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        Stack<Integer> stack = new Stack<>();
        int V = adj.length;
        boolean[] used = new boolean[V];
        for(int v = 0; v < V; v++) {
            if(!used[v]) postOrder(v, adj, used, stack);
        }

        adj = reverse(adj);

        boolean[] visited = new boolean[V];
        int count = 0;
        while(!stack.empty()) {
            int u = stack.pop();
            if(!visited[u]) {
                dfs(u, visited, adj);
                count++;
            }
        }
        return count;
    }

    private static void postOrder(int s, ArrayList<Integer>[] adj, boolean[] used, Stack<Integer> stack) {
        used[s] = true;
        for(int w : adj[s]) {
            if(!used[w]) {
                postOrder(w, adj, used, stack);
            }
        }
        stack.push(s);
    }

    private static ArrayList<Integer>[] reverse(ArrayList<Integer>[] adj) {
        int V = adj.length;
        ArrayList<Integer>[] neighbors = (ArrayList<Integer>[]) new ArrayList[V];
        for(int v = 0; v < V; v++) neighbors[v] = new ArrayList<>();
        for(int v = 0; v < V; v++) {
            for (int w : adj[v]) {
                neighbors[w].add(v);
            }
        }
        return neighbors;
    }

    private static void dfs(int s, boolean[] visited, ArrayList<Integer>[] adj) {
        visited[s] = true;
        for(int w : adj[s]) {
            if(!visited[w]) dfs(w, visited, adj);
        }
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
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

