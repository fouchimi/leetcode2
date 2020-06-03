import java.util.*;

public class Problem140 {

//    static class TrieNode {
//        String value;
//        TrieNode[] child = new TrieNode[256];
//        public TrieNode() { }
//    }
//
//    TrieNode root = new TrieNode();
//
//    public List<String> wordBreak(String s, List<String> wordDict) {
//        List<String> res = new ArrayList<>();
//        for (String word : wordDict) insert(word);
//        Queue<List<List<String>>> queue = new LinkedList<>();
//        List<String> initialList = new ArrayList<>();
//        initialList.add(s);
//        List<List<String>> list = new ArrayList<>();
//        list.add(initialList);
//        queue.offer(list);
//        List<List<String>> resultList = new ArrayList<>();
//        while (!queue.isEmpty()) {
//            List<List<String>> currentList = queue.poll();
//            List<List<String>> tempCurrentList = new ArrayList<>();
//            for(List<String> curList : currentList) {
//                String key = curList.remove(0);
//                if (key.isEmpty()) {
//                    resultList.add(curList);
//                    continue;
//                }
//                List<String> prefixes = getPrefixes(key, 0);
//                if (prefixes.size() > 0) {
//                    for (String prefix : prefixes) {
//                        List<String> tempList = new ArrayList<>(curList);
//                        String newKey = key.substring(prefix.length());
//                        tempList.add(0, newKey);
//                        tempList.add(prefix);
//                        tempCurrentList.add(tempList);
//                    }
//                }
//            }
//            if(!tempCurrentList.isEmpty()) queue.offer(tempCurrentList);
//        }
//        for (List<String> l : resultList) {
//            StringBuilder sb = new StringBuilder();
//            for (String w : l) sb.append(w).append(" ");
//            res.add(sb.toString().trim());
//        }
//        return res;
//    }
//
//    public void insert(String word) {
//        root = insert(root, word, 0);
//    }
//
//    private TrieNode insert(TrieNode x, String word, int d) {
//        if (x == null) x = new TrieNode();
//        if (d == word.length()) {
//            x.value = word;
//            return x;
//        }
//        int index = word.charAt(d);
//        x.child[index] = insert(x.child[index], word, d + 1);
//        return x;
//    }
//
//    private List<String> getPrefixes(String word, int d) {
//        List<String> prefixes = new ArrayList<>();
//        root = getPrefixes(root, word, d, prefixes);
//        return prefixes;
//    }
//
//    private TrieNode getPrefixes(TrieNode x, String word, int d, List<String> prefixes) {
//        if (x == null) return null;
//        if (x.value != null) prefixes.add(x.value);
//        if (d == word.length()) return x;
//        int index = word.charAt(d);
//        x.child[index] = getPrefixes(x.child[index], word, d + 1, prefixes);
//        return x;
//    }


    List<String> results;
    List<String> wordDict;
    Map<String, List<List<String>>> cache;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        this.results = new ArrayList<>();
        this.cache = new HashMap<>();
        for (String w: wordDict) {
            if (s.startsWith(w)) {
                List<List<String>> lists = dfs(s.substring(w.length()));
                if (!lists.isEmpty()) {
                    for (List<String> l: lists) {
                        l.add(w);
                    }
                }

                for (List<String> l: lists) {
                    StringBuilder sb = new StringBuilder();
                    for (int i = l.size()-1; i>=0; i--) {
                        String word = l.get(i);
                        sb.append(word).append(" ");
                    }
                    results.add(sb.substring(0, sb.length()-1));
                }

            }
        }
        return results;
    }

    public List<List<String>> dfs(String s) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.length() == 0) {
            List<String> list = new ArrayList<>();
            List<List<String>> result = new ArrayList<>();
            result.add(list);
            return result;
        }

        List<List<String>> current = new ArrayList<>();
        for (String w: wordDict) {
            if (s.startsWith(w)) {
                List<List<String>> lists = dfs(s.substring(w.length()));
                List<List<String>> clone = new ArrayList<>();
                for (List<String> origin: lists) {
                    clone.add(new ArrayList<>(origin));
                }
                cache.put(s.substring(w.length()), clone);
                if (lists.size() != 0) {
                    for (List<String> l: lists) {
                        l.add(w);
                        current.add(l);
                    }
                }

            }
        }
        return current;
    }

    public static void main(String[] args) {
        Problem140 problem140 = new Problem140();
        System.out.println(problem140.wordBreak("aaaaaaa", Arrays.asList("aaaa", "aaa")));
        System.out.println(problem140.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog")));
        System.out.println(problem140.wordBreak("pineapplepenapple", Arrays.asList("apple", "pen", "applepen", "pine", "pineapple")));
//        System.out.println(problem140.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
//                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa")));
    }
}
