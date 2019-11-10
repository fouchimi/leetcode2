import java.util.ArrayList;
import java.util.List;

public class Problem990 {
    static class UF {
        int[] id, rank;
        int N = 26;
        UF() {
            id = new int[N];
            rank = new int[N];
            for (int i = 0; i < id.length; i++) id[i] = i;
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
                rank[qid]++;
            }
        }
    }
    public boolean equationsPossible(String[] equations) {
        if (equations == null || equations.length == 0) return false;
        List<String> list = new ArrayList<>();
        for (String equation : equations) {
            if (equation.indexOf("==") > 0) list.add(0, equation);
            else if (equation.indexOf("!=") > 0) list.add(equation);
        }
        UF uf = new UF();
        for (String equation : list) {
            int p = equation.charAt(0) - 'a', q = equation.charAt(3) - 'a';
            if (equation.indexOf("!=") > 0 && (uf.find(p) == uf.find(q))) return false;
            else if (equation.indexOf("==") > 0 && (uf.find(p) != uf.find(q))) uf.union(p, q);
        }
        return true;
    }

    public static void main(String[] args) {
        Problem990 problem990 = new Problem990();
        String[] equations = {"b!=g","k!=e","c==k","c==b","d!=i","d==k","k!=c"};
        System.out.println(problem990.equationsPossible(equations));
    }
}
