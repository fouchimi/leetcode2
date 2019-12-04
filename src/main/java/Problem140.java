import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        helper(s, wordDict, "", res);
        return res;
    }

    private void helper(String s, List<String> wordDict, String word,  List<String> res) {
        if (s.length() == 0) {
            res.add(word.trim());
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            String currentWord = wordDict.get(i);
            boolean found = false;
            String tempStr = s, tempWord = word;
            while (s.length() >= currentWord.length() && s.startsWith(currentWord)) {
                s = s.substring(currentWord.length());
                word += currentWord + " ";
                found = true;
            }
            if (found) {
                helper(s, wordDict, word, res);
                word = tempWord;
                s = tempStr;
            }
        }
    }

    public static void main(String[] args) {
        Problem140 problem140 = new Problem140();
        String s = "aaaaaaa";
        List<String> wordDict = Arrays.asList("aaaa", "aaa");
        System.out.println(problem140.wordBreak(s, wordDict));
    }
}
