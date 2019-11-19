import java.util.Arrays;
import java.util.List;

public class Problem648 {

    static class Trie {
        private Trie[] children;
        private String word;

        Trie() {
            children = new Trie[256];
            word = "";
        }
    }
    private Trie root = null;

    public String replaceWords(List<String> dict, String sentence) {
        if (sentence == null || sentence.isEmpty()) return "";
        for (String word : dict) insert(word);
        StringBuilder sb = new StringBuilder();
        String[] words = sentence.split( " ");
        for (String word : words) {
            if (getWord(word) == null) sb.append(word).append(" ");
            else sb.append(getWord(word)).append(" ");
        }
        return sb.toString().trim();
    }

    private void insert(String word) {
        root  = insert(root, word, 0);
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

    private String getWord(String word) {
        return getWord(root, word, 0);
    }

    private String getWord(Trie x, String word, int d) {
        if (x == null) return null;
        if (x.word.length() > 0) return x.word;
        if (d == word.length()) return word;
        int index = word.charAt(d);
        return getWord(x.children[index], word, d + 1);
    }

    public static void main(String[] args) {
        Problem648 problem648 = new Problem648();
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(problem648.replaceWords(dict, sentence));
    }
}
