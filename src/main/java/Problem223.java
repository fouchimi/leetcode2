public class Problem223 {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int maxAE = Math.max(A, E), minCG = Math.min(C, G);
        int maxFB = Math.max(F, B), minDH = Math.min(D, H);
        int overlapArea = 0;
        if (doOverlap(A, B, C, D, E, F, G, H)) overlapArea = (minCG - maxAE) * (minDH - maxFB);
        int widthAC = Math.max(A, C) - Math.min(A, C), heightBD = Math.max(B, D) - Math.min(B, D);
        int withEG = Math.max(E, G) - Math.min(E, G), heightHF = Math.max(H, F) - Math.min(H, F);
        return (widthAC * heightBD) + (withEG * heightHF) - overlapArea;
    }

    private boolean doOverlap(int A, int B, int C, int D, int E, int F, int G, int H) {
        return E <= C && A <= G && B <= H && F <= D;
    }

    public static void main(String[] args) {
        Problem223 problem223 = new Problem223();
        System.out.println(problem223.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
        System.out.println(problem223.computeArea(-2, -2, 2, 2, 3, 3, 4, 4));
    }
}
