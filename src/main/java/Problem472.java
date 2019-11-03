import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem472 {
    static class TrieNode {
        char ch;
        String value;
        private TrieNode[] children = new TrieNode[256];
        TrieNode() { }
    }
    private TrieNode root = new TrieNode();
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            List<String> l = new ArrayList<>();
            findOrInsert(word, l);
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < l.size(); i++) sb.append(l.get(i));
            if (sb.toString().equals(word)) res.add(word);
        }
        return res;
    }

    private TrieNode findOrInsert(String word, List<String> list) {
        return findOrInsert(root, word, list, 0);
    }

    private TrieNode findOrInsert(TrieNode x, String word, List<String> list, int d) {
        if (x == null) x = new TrieNode();
        if (x.value != null) {
            int index = word.indexOf(x.value);
            if (index > -1) {
                list.add(x.value);
            }
        }
        if (d == word.length()) {
            x.value = word;
            return x;
        }
        x.ch = word.charAt(d);
        int charIndex = x.ch;
        x.children[charIndex] = findOrInsert(x.children[charIndex], word, list, d+1);
        return x;
    }

    public static void main(String[] args) {
        Problem472 problem472 = new Problem472();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        //String[] words = {"cat","dog","catdog"};
        List<String> res = problem472.findAllConcatenatedWordsInADict(words);
        System.out.println(res);
    }
}
