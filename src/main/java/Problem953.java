import java.util.*;

public class Problem953 {

    public boolean isAlienSorted(String[] words, String order) {
        if (words == null || words.length == 0 || order == null || order.length() == 0) return false;
        Map<Character, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) indexMap.put(order.charAt(i), i);
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (!isLess(words[i], words[j], indexMap)) return false;
            }
        }
        return true;
    }

    private boolean isLess(String first, String second, Map<Character, Integer> map) {
        int i = 0, j = 0;
        while (i < first.length() && j < second.length()) {
            int firstIndex = map.get(first.charAt(i));
            int secondIndex = map.get(second.charAt(j));
            if (firstIndex < secondIndex) return true;
            else if (firstIndex > secondIndex) return false;
            i++;
            j++;
        }
        if (i < first.length()) return false;
        return true;
    }

    public static void main(String[] args) {
        Problem953 problem953 = new Problem953();
        System.out.println(problem953.isAlienSorted(new String[]{"hello","leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
        System.out.println(problem953.isAlienSorted(new String[]{"word","world","row"}, "worldabcefghijkmnpqstuvxyz"));
        System.out.println(problem953.isAlienSorted(new String[]{"iekm", "tpnhnbe"}, "loxbzapnmstkhijfcuqdewyvrg"));
        System.out.println(problem953.isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }
}
