import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Problem1138 {
    class Tuple {
        char ch;
        String path;
        int x, y;
        Tuple(char ch, String path, int x, int y) {
            this.ch = ch;
            this.path = path;
            this.x = x;
            this.y = y;
        }
    }
    public String alphabetBoardPath(String target) {
        char[][] board = {{'a', 'b', 'c', 'd', 'e'},
                {'f', 'g', 'h', 'i', 'j'},
                {'k', 'l', 'm', 'n', 'o'},
                {'p', 'q', 'r', 's', 't'},
                {'u', 'v', 'w', 'x', 'y'},
                {'z', '#', '#', '#', '#'}};
        StringBuilder sb = new StringBuilder();
        Map<Character, int[]> map = new LinkedHashMap<>();
        target = 'a' + target;
        for (int i = 0; i < target.length(); i++) {
            char ch = target.charAt(i);
            if (map.containsKey(ch)) continue;
            int[] position = getPosition(ch, board);
            map.put(ch, position);
        }
        for (int i = 1; i < target.length(); i++) {
            char start = target.charAt(i - 1);
            char end = target.charAt(i);
            sb.append(bfs(start, end, map.get(start)[0], map.get(start)[1], board));
        }
        return sb.toString();
    }

    private int[] getPosition(char ch, char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == ch) return new int[]{i, j};
            }
        }
        return null;
    }

    private String bfs(char start, char end, int x, int y,  char[][] board) {
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(start, "", x, y));
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        boolean[][] visited = new boolean[board.length][board[0].length];
        while (!queue.isEmpty()) {
            Tuple top = queue.poll();
            visited[top.x][top.y] = true;
            if (top.ch == end) return top.path + "!";
            for (int[] dir : dirs) {
                x = top.x + dir[0];
                y = top.y + dir[1];
                if (x < 0 || y < 0 || x >= visited.length || y >= visited[0].length || visited[x][y]) continue;
                if (dir[0] == -1) queue.offer(new Tuple(board[x][y], top.path + "U", x, y));
                else if (dir[1] == -1) queue.offer(new Tuple(board[x][y], top.path + "L", x, y));
                else if (dir[0] == 1) queue.offer(new Tuple(board[x][y], top.path + "D", x, y));
                else queue.offer(new Tuple(board[x][y], top.path + "R", x, y));
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Problem1138 problem1138 = new Problem1138();
        System.out.println(problem1138.alphabetBoardPath("leet"));
        System.out.println(problem1138.alphabetBoardPath("code"));
    }
}
