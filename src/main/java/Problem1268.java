import java.util.*;

public class Problem1268 {

    static class TrieNode {
        String value;
        TrieNode[] child = new TrieNode[256];
        public TrieNode() { }
    }

    TrieNode root = new TrieNode();

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> ans = new ArrayList<>();
        for (String product : products) insert(product);
        for (int i = 0; i < searchWord.length(); i++) {
            String prefix = searchWord.substring(0, i + 1);
            List<String> list = new ArrayList<>();
            search(prefix, list);
            Collections.sort(list);
            while (list.size() > 3) list.remove(list.size() - 1);
            ans.add(list);
        }
        return ans;
    }

    private void insert(String product) {
        root = insert(root, product, 0);
    }

    private TrieNode insert(TrieNode x, String key, int d) {
        if (x == null) x = new TrieNode();
        if (d == key.length()) {
            x.value = key;
            return x;
        }
        int index = key.charAt(d);
        x.child[index] = insert(x.child[index], key, d + 1);
        return x;
    }

    private void search(String prefix, List<String> suggestedList) {
        Queue<TrieNode> queue = new LinkedList<>();
        root = search(root, prefix, 0, queue);
        while (!queue.isEmpty()) {
            TrieNode currentNode = queue.poll();
            if (currentNode.value != null) suggestedList.add(currentNode.value);
            for (int i = 0; i < currentNode.child.length; i++) {
                if (currentNode.child[i] == null) continue;
                queue.offer(currentNode.child[i]);
            }
        }
    }

    private TrieNode search(TrieNode x, String prefix, int d, Queue<TrieNode> q) {
        if (x == null) return null;
        if (d == prefix.length()) {
            q.offer(x);
            return x;
        }
        int index = prefix.charAt(d);
        x.child[index] = search(x.child[index], prefix, d + 1, q);
        return x;
    }

    public static void main(String[] args) {
        Problem1268 problem1268 = new Problem1268();
        List<List<String>> productList = problem1268.suggestedProducts(new String[]{"mobile","mouse","moneypot","monitor","mousepad"}, "mouse");
        productList.forEach(System.out::println);
    }

}
