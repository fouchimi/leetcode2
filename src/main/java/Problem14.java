import java.util.LinkedList;
import java.util.Queue;

public class Problem14 {
    static class Trie {
        private Trie[] children;
        private char ch;
        private int count;

        Trie() {
            children = new Trie[256];
        }
    }

    private Trie root = null;

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (String word : strs) insert(word);
        return getPrefix(strs.length);
    }

    private void insert(String word) {
        root = insert(root, word, 0);
    }

    private Trie insert(Trie x, String word, int d) {
        if (x == null) x = new Trie();
        if (d == word.length()) return x;
        int index = word.charAt(d);
        x.children[index] = insert(x.children[index], word, d + 1);
        x.children[index].ch = word.charAt(d);
        x.children[index].count += 1;
        return x;
    }

    private String getPrefix(int size) {
        return getPrefix(root, size);
    }

    private String getPrefix(Trie x, int size) {
        Queue<Trie> queue = new LinkedList<>();
        queue.offer(x);
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Trie top = queue.poll();
            for (int i = 0; i < top.children.length; i++) {
                if (top.children[i] != null && top.children[i].count == size) {
                    sb.append(top.children[i].ch);
                    queue.offer(top.children[i]);
                }
            }
        }
        return sb.length() == 0 ? "" : sb.toString();
    }

    public static void main(String[] args) {
        Problem14 problem14 = new Problem14();
        String[] words = {"flower","flow","flight"};
        System.out.println(problem14.longestCommonPrefix(words));
    }
}
