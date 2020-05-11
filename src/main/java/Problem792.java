import java.util.*;

public class Problem792 {
//    public int numMatchingSubseq(String S, String[] words) {
//        int count = 0;
//        Map<String, Integer> map = new HashMap<>();;
//        for (String word : words) {
//            map.put(word, map.getOrDefault(word, 0) + 1);
//        }
//        for (String currentWord : map.keySet())
//            if (isSubsequence(currentWord, S)) count += map.get(currentWord);
//        return count;
//    }
//
//    public boolean isSubsequence(String s, String t) {
//        if (s == null || t == null || t.length() < s.length()) return false;
//        if (s.length() == 0) return true;
//        int i = 0, j = t.indexOf(s.charAt(0));
//        for (; j >= 0 && j < t.length(); j++) {
//            if (s.charAt(i) == t.charAt(j)) {
//                if (isSubsequence(s.substring(i + 1), t.substring(j + 1))) {
//                    return true;
//                }
//                return false;
//            }
//        }
//        return false;
//    }

    public int numMatchingSubseq(String S, String[] words) {
        int res = 0;
        char[] ca = S.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for (String word : map.keySet()) if (isSubsequence(word, ca)) res += map.get(word);
        return res;
    }

    private boolean isSubsequence(String s, char[] ca) {
        if (s.length() == 0) return true;
        if (s.length() > ca.length) return false;
        Queue<Character> q = new LinkedList();
        for (char c : s.toCharArray()) q.offer(c);
        for (char c : ca) {
            if (c == q.peek()) q.poll();
            if (q.isEmpty()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Problem792 problem792 = new Problem792();
        System.out.println(problem792.numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"}));
        System.out.println(problem792.numMatchingSubseq("qlhxagxdqh", new String[]{"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"}));
    }
}
