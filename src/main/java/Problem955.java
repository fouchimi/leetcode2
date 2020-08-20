public class Problem955 {
    public int minDeletionSize(String[] A) {
        if (A == null || A.length <= 1) return 0;
        int count = 0;
        while(true) {
            int i = 0;
            if (A[0].length() == 0) break;
            while (i + 1 < A.length && A[i].compareTo(A[i + 1]) <= 0) i++;
            if (i == A.length - 1) break;
            else {
                String current = A[i], next = A[i + 1];
                int j = 0;
                while (j < current.length() && current.charAt(j) == next.charAt(j)) j++;
                deleteAtIndices(A, j);
                count++;
            }
        }
        return count;
    }

    private void deleteAtIndices(String[] A, int index) {
        for (int i = 0; i < A.length; i++) {
            if (index == 0) A[i] = A[i].substring(1);
            else if (index == A[i].length() - 1) A[i] = A[i].substring(0, A[i].length() - 1);
            else A[i] = A[i].substring(0, index) +  A[i].substring(index + 1);
        }
    }

    public static void main(String[] args) {
        Problem955 problem955 = new Problem955();
        System.out.println(problem955.minDeletionSize(new String[]{"abx","agz","bgc","bfc"}));
        System.out.println(problem955.minDeletionSize(new String[]{"ca","bb","ac"}));
        System.out.println(problem955.minDeletionSize(new String[]{"xc","yb","za"}));
        System.out.println(problem955.minDeletionSize(new String[]{"zyx","wvu","tsr"}));
        System.out.println(problem955.minDeletionSize(new String[]{"xga","xfb","yfa"}));
    }
}
