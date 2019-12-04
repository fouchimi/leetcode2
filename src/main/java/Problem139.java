import java.util.*;

public class Problem139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) return true;
        for (int i = 0; i < wordDict.size(); i++) {
            String currentWord = wordDict.get(i);
            boolean found = false;
            String temp = s;
            while (s.length() >= currentWord.length() && temp.startsWith(currentWord)) {
                temp = temp.substring(currentWord.length());
                found = true;
            }
            if (found) {
                if (wordBreak(temp, wordDict)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Problem139 problem139 = new Problem139();
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa");
//        String s = "cars";
//        List<String> wordDict = Arrays.asList("car", "ca", "rs");
//        String s = "applepenapple";
//        List<String> wordDict = Arrays.asList("apple", "pen");
        System.out.println(problem139.wordBreak(s, wordDict));
    }
}
