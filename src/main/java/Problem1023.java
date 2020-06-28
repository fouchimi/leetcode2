import java.util.ArrayList;
import java.util.List;

public class Problem1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for(String query : queries) {
            int i = 0, j = 0;
            while (i < query.length() && j < pattern.length()) {
                if (Character.isUpperCase(query.charAt(i)) && query.charAt(i) != pattern.charAt(j)) break;
                else if (query.charAt(i) == pattern.charAt(j)) j++;
                i++;
            }

            boolean found = false;
            while (i < query.length()) {
                if (Character.isUpperCase(query.charAt(i))) {
                    found = true;
                    break;
                }
                i++;
            }
            if (found) result.add(false);
            else result.add(j == pattern.length());
        }

        return result;
    }

    public static void main(String[] args) {
        Problem1023 problem1023 = new Problem1023();
        problem1023.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FB");
        problem1023.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBa");
        problem1023.camelMatch(new String[]{"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"}, "FoBaT");
    }
}
