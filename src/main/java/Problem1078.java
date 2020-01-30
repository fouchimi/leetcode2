import java.util.ArrayList;
import java.util.List;

public class Problem1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < words.length) {
            if (words[i].equals(first)) {
                if (i + 1 < words.length && words[i + 1].equals(second)) {
                    if (i + 2 < words.length)  {
                        res.add(words[i + 2]);
                        i = i + 2;
                    } else i++;
                } else i++;
            } else i++;
        }
        String[] ans = new String[res.size()];
        for (int j = 0; j < ans.length; j++) ans[j] = res.get(j);
        return ans;
    }

    private void print(String[] res) {
        for (String val : res) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Problem1078 problem1078 = new Problem1078();
        problem1078.print(problem1078.findOcurrences("alice is a good girl she is a good student", "a", "good"));
        problem1078.print(problem1078.findOcurrences("we will we will rock you", "we", "will"));
    }
}
