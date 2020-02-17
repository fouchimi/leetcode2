public class Problem1232 {

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) return true;
        int[] pointA = coordinates[0], pointB = coordinates[1];
        double m = getSlope(pointA, pointB);
        double b = getConstant(pointA, m);
        for (int i = 3; i < coordinates.length; i++) {
            if (coordinates[i][1] != (int)(m * coordinates[i][0] + b)) return false;
        }
        return true;
    }

    private double getSlope(int[] A, int[] B) {
        return 1.0 *(B[1] - A[1]) / (B[0] - A[0]);
    }

    private double getConstant(int[] A, double m) {
        return  A[1] - m * A[0];
    }

    public static void main(String[] args) {
        Problem1232 problem1232 = new Problem1232();
        System.out.println(problem1232.checkStraightLine(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {7, 7}}));
    }
}
