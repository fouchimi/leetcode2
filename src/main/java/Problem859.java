import java.util.HashMap;
import java.util.Map;

public class Problem859 {

    public boolean buddyStrings(String A, String B) {
        if (A == null || B == null || A.length() == 0 || B.length() == 0 || A.length() != B.length()) return false;
        Map<Character, Integer> mapA = new HashMap<>();
        Map<Character, Integer> mapB = new HashMap<>();

        int diff = 0, N  = A.length(), prevIndex = -1;
        char[] charsA = A.toCharArray();

        for (int i = 0; i < N; i++) {
            char a = A.charAt(i), b = B.charAt(i);
            if (a != b) {
                diff++;
                if (diff > 2) return false;
                if (diff == 2) {
                    char temp = charsA[prevIndex];
                    charsA[prevIndex] = charsA[i];
                    charsA[i] = temp;
                    String newA = new String(charsA);
                    return newA.equals(B);
                }
                prevIndex = i;
            }

            mapA.put(a, mapA.getOrDefault(a, 0) + 1);
            mapB.put(b, mapB.getOrDefault(b, 0) + 1);
        }

        for (char key : mapA.keySet()) {
            if (!mapB.containsKey(key) || mapA.get(key) % 2 != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Problem859 problem859 = new Problem859();
        System.out.println(problem859.buddyStrings("ab", "ba"));
        System.out.println(problem859.buddyStrings("ab", "ab"));
        System.out.println(problem859.buddyStrings("aa", "aa"));
        System.out.println(problem859.buddyStrings("aaaaaaabc", "aaaaaaacb"));
        System.out.println(problem859.buddyStrings("", "aa"));
    }
}
