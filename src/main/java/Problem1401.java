public class Problem1401 {

    public boolean checkOverlap(int radius, int x_center, int y_center, int x1, int y1, int x2, int y2) {
        if ((computeDist(x_center, y_center, x1, y1) <= radius * radius)     ||
                (computeDist(x_center, y_center, x1, y2) <= radius * radius) ||
                (computeDist(x_center, y_center, x2, y1) <= radius * radius) ||
                (computeDist(x_center, y_center, x2, y2) <= radius * radius) ||
                (x_center - radius <= x1  && x1 <= x_center + radius  && y1 <= y_center && y_center <= y2)  ||
                (x_center - radius <= x2  && x2 <= x_center + radius  && y1 <= y_center && y_center <= y2)  ||
                (y_center - radius <= y1  && y1 <= y_center + radius  && x1 <= x_center && x_center <= x2)  ||
                (y_center - radius <= y2  && y2 <= y_center + radius  && x1 <= x_center && x_center <= x2)  ||
                (x1 <= x_center && x_center <= x2 && y1 <= y_center && y_center <= y2)) return true;
        return false;
    }

    private int computeDist(int x0, int y0, int x1, int y1) {
        return (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
    }

    public static void main(String[] args) {
        Problem1401 problem1401 = new Problem1401();
        System.out.println(problem1401.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(problem1401.checkOverlap(1, 0, 0, -1, 0, 0, 1));
        System.out.println(problem1401.checkOverlap(1, 1, 1, -3, -3, 3 ,3));
        System.out.println(problem1401.checkOverlap(1, 1, 1, 1, -3, 2, -1));
    }
}
