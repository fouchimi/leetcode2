import java.util.LinkedList;
import java.util.Queue;

public class Problem677 {
    class Trie {
        private Trie[] children;
        private int value;
        private String word;

        private Trie() {
            children = new Trie[256];
            value = 0;
            word = "";
        }
    }

    private Trie root = null;

    public Problem677() {

    }

    public void insert(String key, int val) {
        root = insert(root, key, val, 0);
    }

    private Trie insert(Trie x, String key, int val,  int d) {
        if (x == null) x = new Trie();
        if (d == key.length()) {
            x.value = val;
            x.word = key;
            return x;
        }
        int index = key.charAt(d);
        x.children[index] = insert(x.children[index], key, val, d + 1);
        return x;
    }

    public int sum (String prefix) {
        Trie start = getStartNode(root, prefix, 0);
        if (start == null) return 0;
        else return getSum(start);
    }

    private int getSum(Trie x) {
        Queue<Trie> queue = new LinkedList<>();
        queue.offer(x);
        int maxSum = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if (queue.isEmpty()) break;
                Trie top = queue.poll();
                if (top.word.length() > 0) maxSum += top.value;
                for (int j = 0; j < top.children.length; j++) {
                    Trie next = top.children[j];
                    if (next != null) queue.offer(next);
                }
            }
        }
        return maxSum;
    }

    private Trie getStartNode(Trie x, String prefix, int d) {
        if (x == null) return null;
        if (d == prefix.length()) return x;
        int index = prefix.charAt(d);
        return getStartNode(x.children[index], prefix, d + 1);
    }

    public static void main(String[] args) {
        Problem677 problem677 = new Problem677();
//        problem677.insert("apple", 3);
//        System.out.println(problem677.sum("ap"));
//        problem677.insert("app", 2);
//        System.out.println(problem677.sum("ap"));
//        problem677.insert("a", 3);
//        System.out.println(problem677.sum("ap"));
//        problem677.insert("b", 2);
//        System.out.println(problem677.sum("a"));
        problem677.insert("aa", 3);
        System.out.println(problem677.sum("a"));
        problem677.insert("aa", 2);
        System.out.println(problem677.sum("a"));
        System.out.println(problem677.sum("aa"));
        problem677.insert("aaa", 3);
        System.out.println(problem677.sum("aaa"));
        System.out.println(problem677.sum("bbb"));
        System.out.println(problem677.sum("ccc"));
        problem677.insert("aewfwaefjeoawefjwoeajfowajfoewajfoawefjeowajfowaj", 111);
        System.out.println(problem677.sum("aa"));
        System.out.println(problem677.sum("a"));
    }
}
