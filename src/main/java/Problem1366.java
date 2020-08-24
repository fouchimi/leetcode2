import java.util.*;

public class Problem1366 {

    public String rankTeams(String[] votes) {
        if (votes == null || votes.length == 0) return null;
        Map<Character, int[]> map = new HashMap<>();
        String firstVote = votes[0];
        int N = firstVote.length();
        for (int i = 0; i < N; i++) map.put(firstVote.charAt(i), new int[N]);
        for (String vote : votes) {
            for (int j = 0; j < vote.length(); j++) {
                char ch = vote.charAt(j);
                map.get(ch)[j]++;
            }
        }
        List<Map.Entry<Character, int[]>> list = new ArrayList<>(map.entrySet());
        list.sort((first, second) -> {
            int index = 0;
            while (index < N && second.getValue()[index] == first.getValue()[index]) index++;
            if (index == N) return second.getValue()[N - 1] - first.getValue()[N - 1];
            return second.getValue()[index] - first.getValue()[index];
        });

        StringBuilder sb = new StringBuilder();

        for (Map.Entry<Character, int[]> entry : list) sb.append(entry.getKey());

        return sb.toString();
    }

    public static void main(String[] args) {
        Problem1366 problem1366 = new Problem1366();
        System.out.println(problem1366.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }


}
