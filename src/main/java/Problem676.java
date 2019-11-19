
public class Problem676 {
    private class Trie {
        private Trie[] children;
        private String value;

        private Trie() {
            children = new Trie[256];
            value = "";
        }
    }

    private Trie root = null;

    public void buildDict(String[] dict) {
        for (String word : dict) insert(word);
    }

    private void insert(String word) {
        root = insert(root, word, 0);
    }

    private Trie insert(Trie x, String word, int d) {
        if (x == null) x = new Trie();
        if (d == word.length()) {
            x.value = word;
            return x;
        }
        int index = word.charAt(d);
        x.children[index] = insert(x.children[index], word, d + 1);
        return x;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            for (int i = 0; i < chars.length; i++) {
                char tempChar = chars[i];
                chars[i] = ch;
                String newWord = new String(chars);
                if (search(root, newWord, 0) && !newWord.equals(word)) return true;
                chars[i] = tempChar;
            }
        }
        return false;
    }

    private boolean search(Trie x, String word, int d) {
        if (x == null) return false;
        if (d == word.length()) return x.value.equals(word);
        int index = word.charAt(d);
        return search(x.children[index], word, d + 1);
    }


    public static void main(String[] args) {
        Problem676 problem676 = new Problem676();
        String[] dict = {"hello","hallo","leetcode","judge", "judgg"};
        problem676.buildDict(dict);
        System.out.println(problem676.search("hello"));
        System.out.println(problem676.search("hallo"));
        System.out.println(problem676.search("hell"));
        System.out.println(problem676.search("leetcodd"));
        System.out.println(problem676.search("judge"));
        System.out.println(problem676.search("juggg"));
    }

}
