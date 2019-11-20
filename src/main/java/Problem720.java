import java.util.Arrays;

public class Problem720 {

    class Trie {
        private Trie[] children;
        private String word;

        Trie() {
            children = new Trie[256];
        }
    }

    private Trie root = null;

    public String longestWord(String[] words) {
        if (words == null || words.length == 0) return null;
        Arrays.sort(words);
        for (String word : words) insert(word);
        String maxPrefix = "";
        for(String word : words) {
            int i = 0;
            for (; i < word.length(); i++) {
                String prefix = word.substring(0, i);
                if (!isPrefix(prefix) && prefix.length() > 0) break;
            }
            if (i == word.length() && word.length() > maxPrefix.length()) maxPrefix = word;
        }
        return maxPrefix;
    }

    private void insert(String word) {
        root = insert(root, word, 0);
    }

    private Trie insert(Trie x, String word, int d) {
        if (x == null) x = new Trie();
        if (d == word.length()) {
            x.word = word;
            return x;
        }
        int index = word.charAt(d);
        x.children[index] = insert(x.children[index], word, d + 1);
        return x;
    }

    private boolean isPrefix(String word) {
        return isPrefix(root, word, 0);
    }

    private boolean isPrefix(Trie x, String prefix, int d) {
        if (x == null) return false;
        if (d == prefix.length()) return x.word != null;
        int index = prefix.charAt(d);
        return isPrefix(x.children[index], prefix, d + 1);
    }

    public static void main(String[] args) {
        Problem720 problem720 = new Problem720();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
        System.out.println(problem720.longestWord(words));
    }
}
