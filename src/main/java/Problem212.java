import java.util.*;

public class Problem212 {
    static class Trie {
        Trie[] children;
        String word;

        Trie() {
            children = new Trie[256];
        }
    }

    private Trie root = null;

    private int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if (words == null || words.length == 0) return res;
        for (String word : words) insert(word);
        return search(board);
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

    private List<String> search(char[][] board) {
        int rows = board.length, cols = board[0].length;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs (board, root, i, j, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, Trie node, int row, int col, List<String> res) {
        if (node == null) return;

        if (node.word != null) {
           res.add(node.word);
           node.word = null;
        }

       if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) return;
       char c = board[row][col];
       int index = board[row][col];
       board[row][col] = '@';
       for (int[] dir : dirs) {
           int x = row + dir[0];
           int y = col + dir[1];
           dfs(board, node.children[index], x, y, res);
       }
       board[row][col] = c;
    }

    public static void main(String[] args) {
        Problem212 problem212 = new Problem212();
//        char[][] board = {{'o','a','a','n'},
//                {'e','t','a','e'},
//                {'i','h','k','r'},
//                {'i','f','l','v'}};
        char[][] board = {{'a', 'b'}, {'a', 'a'}};
//        String[] words = {"oath","pea","eat","rain"};
        String[] words = {"aba","baa","bab","aaab","aaa","aaaa","aaba"};
        System.out.println(problem212.findWords(board, words));
    }
}
