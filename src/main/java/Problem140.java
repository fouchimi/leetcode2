import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem140 {

    static class TrieNode {
        String value;
        TrieNode[] child = new TrieNode[256];
        public TrieNode() { }
    }

    TrieNode root = new TrieNode();

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        for (String word : wordDict) insert(word);
        dfs(s, res);
        return res;
    }

    public void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.value = word;
            return x;
        }
        int index = word.charAt(d);
        x.child[index] = insert(x.child[index], word, d + 1);
        return x;
    }

    private void dfs (String needle, List<String> res) {
        root = dfs(root, needle, new ArrayList<>(), res, 0);
    }

    private TrieNode dfs (TrieNode x, String word, List<String> tempList, List<String> res, int d) {
        if (x == null) return null;
        if (word.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (String key : tempList) sb.append(key).append(" ");
            res.add(sb.toString().trim());
            return x;
        }
        if (x.value != null) {
            tempList.add(x.value);
            int startIndex = x.value.length();
            dfs(root, word.substring(startIndex), tempList, res, 0);
            tempList.remove(tempList.size() - 1);
        }
        if (word.length() == d) return x;
        int index = word.charAt(d);
        x.child[index] = dfs(x.child[index], word, tempList, res, d + 1);
        return x;
    }

    public static void main(String[] args) {
        Problem140 problem140 = new Problem140();
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        System.out.println(problem140.wordBreak(s, wordDict));
        System.out.println(problem140.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
    }
}
