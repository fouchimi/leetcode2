import java.util.Arrays;

public class Problem957 {

    public int[] prisonAfterNDays(int[] cells, int N) {
        int[] temp = new int[cells.length];
        int day = 0;
        N = N%14 == 0 ? 14 : N%14;
        while (day < N) {
            for(int i = 1; i < cells.length-1; i++) {
                if(cells[i-1] == cells[i+1]) {
                    temp[i] = 1;
                } else temp[i] = 0;
            }
            cells = temp.clone();
            day++;
        }
        return cells;
    }

    public static void main(String[] args) {
        Problem957 problem957 = new Problem957();
        int[] cells = {0,1,0,1,1,0,0,1};
        Arrays.stream(problem957.prisonAfterNDays(cells, 7)).forEach(System.out::println);
    }
}
