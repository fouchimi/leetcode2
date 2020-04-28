
public class Problem1035 {
    public int maxUncrossedLines(int[] A, int[] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) return 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i;
            while (j < B.length) {
                j++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Problem1035 problem1035 = new Problem1035();
//        System.out.println(problem1035.maxUncrossedLines(new int[]{1, 4, 2}, new int[]{1, 2, 4}));
        System.out.println(problem1035.maxUncrossedLines(new int[]{2, 5, 1, 2, 5}, new int[]{10, 5, 2, 1, 5, 2}));
        System.out.println(problem1035.maxUncrossedLines(new int[]{1, 3, 7, 1, 7, 5}, new int[]{1, 9, 2, 5, 1}));
    }
}
