public class Problem836 {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        // if rec1 is in the left of rec2
        if (rec2[0] >= rec1[0] && rec2[0] < rec1[2]) {
            return (rec2[3] >= rec1[1] && rec2[3] <= rec1[3]) || (rec1[3] >= rec2[1] && rec1[3] <= rec2[3]);
        }
        // if rec1 is in the right of rec2
        else if (rec1[0] >= rec2[0] && rec1[0] < rec2[2]) {
            return (rec1[3] >= rec2[1] && rec1[3] <= rec2[3]) || (rec2[3] >= rec1[1] && rec2[3] <= rec1[3]);
        }
        return false;
    }

    public static void main(String[] args) {
        Problem836 problem836 = new Problem836();
        System.out.println(problem836.isRectangleOverlap(new int[]{0, 0, 2, 2}, new int[]{1, 1, 3, 3}));
        System.out.println(problem836.isRectangleOverlap(new int[]{0, 0, 1, 1}, new int[]{1, 0, 2, 1}));
    }
}
