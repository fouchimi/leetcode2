import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem500 {

    public String[] findWords(String[] words) {
        List<Character>[] dict = new ArrayList[3];
        dict[0] = new ArrayList<>(Arrays.asList('Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P'));
        dict[1] = new ArrayList<>(Arrays.asList('A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L'));
        dict[2] = new ArrayList<>(Arrays.asList('Z', 'X', 'C', 'V', 'B', 'N', 'M'));
        List<String> tempList = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i].toUpperCase();
            char ch = word.charAt(0);
            if (dict[0].contains(ch)) search(word, dict[0], tempList, i, words);
            else if (dict[1].contains(ch)) search(word, dict[1], tempList, i, words);
            else search(word, dict[2], tempList, i, words);
        }
        String[] res = new String[tempList.size()];
        for (int i = 0; i < res.length; i++) res[i] = tempList.get(i);
        return res;
    }

    private void search(String word, List<Character> list, List<String> res, int index, String[] words) {
        for (int i = 0; i < word.length(); i++) {
            if (!list.contains(word.charAt(i))) return;
        }
        res.add(words[index]);
    }

    public static void main(String[] args) {
        Problem500 problem500 = new Problem500();
        String[] res = problem500.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        //String[] res = problem500.findWords(new String[]{"a", "b"});
        for (String val : res) System.out.print(val + " ");
    }
}
