public class Problem208 {
    private Trie root = null;
    class Trie {
        private String word;
        private Trie[] children;

        public Trie() {
            children = new Trie[256];
            word = "";
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            root = insert(root, word, 0);
        }

        private Trie insert(Trie x, String word, int d) {
            if (x == null) x = new Trie();
            if (d == word.length()) {
                x.word = word;
                return x;
            }
            int index = word.charAt(d);
            x.children[index] = insert(x.children[index], word, d+1);
            return x;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            return search(root, word, 0);
        }

        private boolean search(Trie x, String word, int d) {
            if (x == null) return false;
            if (d == word.length()) return  x.word.equals(word);
            int index = word.charAt(d);
            return search(x.children[index], word, d + 1);
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            return startsWith(root, prefix, 0);
        }

        private boolean startsWith(Trie x, String prefix, int d) {
            if (x == null) return false;
            if (d == prefix.length()) return true;
            int index = prefix.charAt(d);
            return startsWith(x.children[index], prefix, d + 1);
        }
    }

    public static void main(String[] args) {
        Problem208 problem208 = new Problem208();
        Problem208.Trie trie = problem208.new Trie();
        trie.insert("apple");
        System.out.println( trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }
}
