public class Problem785 {

    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] colors = new int[V];
        for(int v = 0; v < V; v++) {
            if(colors[v] == 0 && !dfs(graph, colors, 1, v)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int color, int s) {
        if(colors[s] != 0) {
            return colors[s] == color;
        } else {
            colors[s] = color;
            for(int neighbor : graph[s]) {
                if(!dfs(graph, colors, -color, neighbor)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Problem785 problem785 = new Problem785();
        int[][] graph = {{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.println(problem785.isBipartite(graph));
    }
}
