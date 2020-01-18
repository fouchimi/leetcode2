
public class Problem789 {

    public boolean escapeGhosts (int[][] ghosts, int[] target) {
        int toTarget = dist(target, new int[]{0, 0});
        for (int[] g : ghosts) {
            if (dist(target, g) <= toTarget) return false;
        }
        return true;
    }

    private int dist (int[] p0, int[] p1) {
        return Math.abs(p0[0]-p1[0]) + Math.abs(p0[1]-p1[1]);
    }

    public static void main(String[] args) {
        Problem789 problem789 = new Problem789();
        System.out.println(problem789.escapeGhosts(new int[][]{{1, 0}, {0, 3}}, new int[]{0, 1}));
        System.out.println(problem789.escapeGhosts(new int[][]{{1, 0}}, new int[]{2, 0}));
        System.out.println(problem789.escapeGhosts(new int[][]{{2, 0}}, new int[]{1, 0}));
    }
}
