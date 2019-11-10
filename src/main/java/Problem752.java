import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Problem752 {
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        String start = "0000";
        q.offer(start);
        visited.add(start);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                if (q.isEmpty()) break;
                String top = q.poll();
                if (top.equals(target)) return level;
                if (isValid(top, deadends)) {
                    getNeighbors(top, q, visited);
                }
            }
            level++;
        }
        return -1;
    }

    private boolean isValid(String currentCode, String[] deadens) {
        for (String code : deadens) {
            if (currentCode.equals(code)) return false;
        }
        return true;
    }

    private void getNeighbors(String code, Queue<String> q, Set<String> visited) {
        for (int i = 0; i < code.length(); i++) {
            char[] codeChars = code.toCharArray();
            int val = Character.getNumericValue(codeChars[i]);
            int left = val - 1, right = (val + 1) % 10;
            if (left < 0) left = 9;
            codeChars[i] = Character.forDigit(left, 10);
            String newLeftCode = new String(codeChars);
            if (!visited.contains(newLeftCode)) {
                q.offer(newLeftCode);
                visited.add(newLeftCode);
            }
            codeChars[i] = Character.forDigit(right, 10);
            String newRightCode = new String(codeChars);
            if (!visited.contains(newRightCode)) {
                q.offer(newRightCode);
                visited.add(newRightCode);
            }

        }
    }

    public static void main(String[] args) {
        Problem752 problem752 = new Problem752();
        String[] deadens = {"0201","0101","0102","1212","2002"};
        System.out.println(problem752.openLock(deadens, "0202"));
    }
}
