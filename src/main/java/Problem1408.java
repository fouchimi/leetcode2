import java.util.*;

public class Problem1408 {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        Set<String> set = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (words[j].contains(words[i])) {
                    set.add(words[i]);
                    break;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        Problem1408 problem1408 = new Problem1408();
//        System.out.println(problem1408.stringMatching(new String[]{"mass","as","hero","superhero"}));
//        System.out.println(problem1408.stringMatching(new String[]{"leetcode","et","code"}));
//        System.out.println(problem1408.stringMatching(new String[]{"blue","green","bu"}));
        System.out.println(problem1408.stringMatching(new String[]{"leetcoder","leetcode","od","hamlet","am"}));
    }
}
