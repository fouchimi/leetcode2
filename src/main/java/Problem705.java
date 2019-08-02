import java.util.ArrayList;
import java.util.List;

public class Problem705 {

    List<Integer> set;

    public Problem705() {
        set = new ArrayList<>();
    }

    public void add(int key) {
        if(contains(key)) return;
        set.add(key);
    }

    public void remove(int key) {
        set.remove(new Integer(key));
    }

    public boolean contains(int key) {
        return set.contains(key);
    }

    public static void main(String[] args) {
        Problem705 problem705 = new Problem705();
        problem705.add(1);
        problem705.add(2);
        System.out.println(problem705.contains(1));
        System.out.println(problem705.contains(3));
        problem705.add(2);
        System.out.println( problem705.contains(2));
        problem705.remove(2);
        System.out.println(problem705.contains(2));
    }

}
