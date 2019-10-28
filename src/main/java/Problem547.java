public class Problem547 {

    class UF {

        int[] rank, parent;
        int count;

        public UF(int N) {
            rank = new int[N];
            parent = new int[N];
            count = N;
            for (int i = 0; i < N; i++) parent[i] = i;
        }

        private int find(int id) {
            if(parent[id] != id) {
                parent[id] = find(parent[parent[id]]);
            }
            return parent[id];
        }

        private void union(int p, int q) {
            int pId = find(p);
            int qId = find(q);

            if (pId == qId) return;

            if (rank[pId] < rank[qId]) {
                parent[pId] = qId;
            } else  {
                parent[qId] = pId;
                if (rank[pId] == rank[qId]) rank[qId]++;
            }
            count--;
        }

        private int count() {
            return count;
        }
    }

    public int findCircleNum(int[][] M) {
        if (M == null || M.length == 0) return 0;
        int N = M.length;
        UF uf = new UF(N);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count();
    }

    public static void main(String[] args) {
        Problem547 problem547 = new Problem547();
        int[][] M = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(problem547.findCircleNum(M));
    }
}
