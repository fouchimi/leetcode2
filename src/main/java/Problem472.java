import java.util.*;

public class Problem472 {

    static class TrieNode {
        String value;
        private TrieNode[] children = new TrieNode[256];
        TrieNode() { }
    }

    private TrieNode root = new TrieNode();

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (e1, e2) -> {
            if (e1.length() < e2.length()) return -1;
            else if (e1.length() > e2.length()) return 1;
            return 0;
        });

        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.isEmpty()) continue;
            if (hasPrefix(word)) {
                if (isConcatenatedWord(word)) {
                    res.add(word);
                }
            }
            insert(word);
        }
        return res;
    }

    private void insert(String word) {
        root = insert(root, word, 0);
    }

    private TrieNode insert(TrieNode x, String word, int d) {
        if (x == null) x = new TrieNode();
        if (d == word.length()) {
            x.value = word;
            return x;
        }
        int index = word.charAt(d);
        x.children[index] = insert(x.children[index], word, d + 1);
        return x;
    }

    private boolean hasPrefix(String word) {
        return hasPrefix(root, word, 0);
    }

    private boolean hasPrefix(TrieNode x, String word, int d) {
        if (x == null) return false;
        if (x.value != null) return true;
        int index = word.charAt(d);
        return hasPrefix(x.children[index], word, d + 1);
    }

    private boolean isConcatenatedWord(String word) {
        if (word.length() == 0) return true;
        List<String> prefixList = getPrefixList(word);
        for (String prefix : prefixList) {
            int startIndex = prefix.length();
            String suffix = word.substring(startIndex);
            if (isFound(suffix) || isConcatenatedWord(suffix)) return true;
        }
        return false;
    }

    private List<String> getPrefixList(String word) {
        List<String> prefixList = new ArrayList<>();
        root = getPrefixList(root, word, prefixList, 0);
        return prefixList;
    }

    private TrieNode getPrefixList(TrieNode x, String word, List<String> prefixList, int d) {
        if (x == null) return null;
        if (d == word.length()) return x;
        if (x.value != null) prefixList.add(x.value);
        int index = word.charAt(d);
        x.children[index] = getPrefixList(x.children[index], word, prefixList, d + 1);
        return x;
    }

    private boolean isFound(String word) {
        return isFound(root, word, 0);
    }

    private boolean isFound(TrieNode x, String word, int d) {
        if (x == null) return false;
        if (d == word.length()) {
            if (x.value == null) return false;
            return true;
        }
        int index = word.charAt(d);
        return isFound(x.children[index], word, d + 1);
    }

    public static void main(String[] args) {
        Problem472 problem472 = new Problem472();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
//        String[] words = {"cat","dog","catdog"};
        List<String> res = problem472.findAllConcatenatedWordsInADict(words);
        System.out.println(res);
    }
}
