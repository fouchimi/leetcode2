import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem211 {
    static class WordDictionary {
        private WordDictionary[] children;
        private Map<Integer, List<String>> map;
        private String word;
        /** Initialize your data structure here. */
        WordDictionary() {
            children = new WordDictionary[256];
            map = new HashMap<>();
            word = "";
        }

        WordDictionary root = null;

        /** Adds a word into the data structure. */
        public void addWord(String word) {
            root = addWord(root, word, 0);
        }

        private WordDictionary addWord(WordDictionary x, String word, int d) {
            if (x == null) x = new WordDictionary();
            if (d == word.length()) {
                if (!x.word.isEmpty()) return x;
                x.word = word;
                int size = word.length();
                List<String> list = map.get(size);
                if (list == null) list = new ArrayList<>();
                list.add(word);
                map.put(size, list);
                return x;
            }
            int index = word.charAt(d);
            x.children[index] = addWord(x.children[index], word, d + 1);
            return x;
        }

        /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
        public boolean search(String word) {
            if (word.indexOf('.') >= 0)  {
                int d = 0, length = word.length();
                while (d < length && word.charAt(d) == '.') d++;
                List<String> list = map.get(length);
                if (list == null) return false;
                if (d == length) return true;
                for (String dictWord : list) {
                    if (dictWord.charAt(d) != word.charAt(d) && word.charAt(d) != '.') continue;
                    WordDictionary start = advanced(root, dictWord, d, 0);
                    if (found(start, dictWord, word, d)) return true;

                }
                return false;
            }
            return search(root, word, 0);
        }

        private boolean search(WordDictionary x, String word, int d) {
            if (x == null) return false;
            if (d == word.length()) return x.word != null && x.word.equals(word);
            int index = word.charAt(d);
            return search(x.children[index], word, d + 1);
        }

        private boolean found(WordDictionary x, String word, String target, int d) {
            if (d == word.length()) return true;
            int index = word.charAt(d);
            if (word.charAt(d) != target.charAt(d) && target.charAt(d) != '.') return false;
            return found(x.children[index], word, target, d + 1);
        }

        private WordDictionary advanced(WordDictionary x, String word, int length, int d) {
            if (length == 0) return x;
            int index = word.charAt(d);
            return advanced(x.children[index], word, length - 1, d + 1);
        }
    }

    public static void main(String[] args) {
        Problem211 problem211 = new Problem211();
        Problem211.WordDictionary wordDictionary = new WordDictionary();
//        wordDictionary.addWord("bad");
//        wordDictionary.addWord("dad");
//        wordDictionary.addWord("mad");
//        System.out.println(wordDictionary.search("pad"));
//        System.out.println(wordDictionary.search("bad"));
//        System.out.println(wordDictionary.search(".ad"));
//        System.out.println(wordDictionary.search("b.."));
//        wordDictionary.addWord("a");
//        wordDictionary.addWord("a");
//        System.out.println(wordDictionary.search("."));
//        System.out.println(wordDictionary.search("aa"));
//        System.out.println(wordDictionary.search("a"));
//        System.out.println(wordDictionary.search(".a"));
//        System.out.println(wordDictionary.search("a."));
        wordDictionary.addWord("at");
        wordDictionary.addWord("and");
        wordDictionary.addWord("an");
        wordDictionary.addWord("add");
        System.out.println(wordDictionary.search("a"));
        System.out.println(wordDictionary.search(".at"));
        wordDictionary.addWord("bat");
        System.out.println(wordDictionary.search(".at"));
        System.out.println(wordDictionary.search("an."));
        System.out.println(wordDictionary.search("a.d."));
        System.out.println(wordDictionary.search("b."));
        System.out.println(wordDictionary.search("a.d"));
        System.out.println(wordDictionary.search("."));


    }

}
