public class Problem684 {
    static class UF {
        int[] id, rank;
        UF(int N) {
            id = new int[N];
            rank = new int[N];
            for (int i = 0; i < N; i++) id[i] = i;
        }

        private int find(int p) {
            if (p != id[p]) {
                id[p] = find(id[p]);
            }
            return id[p];
        }

        private void union(int p, int q) {
            int pid = find(p);
            int qid = find(q);

            if (pid == qid) return;

            if (rank[pid] < rank[qid]) id[pid] = qid;
            else if (rank[pid] > rank[qid]) id[qid] = pid;
            else {
                id[pid] = qid;
                rank[pid]++;
            }
        }

    }
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length+1;
        UF uf = new UF(N);
        int[] pair = null;
        for (int i = 0; i < N; i++) {
            pair = edges[i];
            if (uf.find(pair[0]) == uf.find(pair[1])) break;
            uf.union(pair[0], pair[1]);
        }
        return pair;
    }

    public static void main(String[] args) {
        Problem684 problem684 = new Problem684();
        int[][] grid = {{1,2}, {2,3}, {3,4}, {1,4}, {1,5}};
        int[] res = problem684.findRedundantConnection(grid);
        if (res != null) {
            System.out.println("[" + res[0] + " " + res[1] + "]");
        }
    }
}
