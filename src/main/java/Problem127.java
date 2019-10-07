import java.util.*;

public class Problem127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dic = new HashSet<>(wordList);
        if (!dic.contains(endWord)) return 0;

        Queue<String> q = new ArrayDeque<>();
        int steps = 0;
        int len = beginWord.length();
        q.offer(beginWord);
        while (!q.isEmpty()) {
            steps++;
            int size = q.size();
            for (int s = size; s > 0; --s) {
                String word = q.poll();
                if(word == null) break;
                char[] chars = word.toCharArray();
                for (int i = 0; i < len; i++) {
                    char ch = chars[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == ch) continue;
                        chars[i] = c;
                        String t = new String(chars);
                        if (t.equals(endWord)) return steps+1;
                        if (!dic.contains(t)) continue;
                        dic.remove(t);
                        q.offer(t);
                    }
                    chars[i] = ch;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Problem127 problem127 = new Problem127();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(problem127.ladderLength("hit", "cog", wordList));
    }
}
