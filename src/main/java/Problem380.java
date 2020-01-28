import java.util.*;

public class Problem380 {
    Map<Integer, Integer> map;
    public Problem380() {
        map = new LinkedHashMap<>();
    }

    public boolean insert(int val) {
        boolean isFound = map.containsKey(val);
        if (isFound) return false;
        map.put(val, 1);
        return true;
    }

    public boolean remove(int val) {
        boolean isFound = map.containsKey(val);
        if (!isFound) return false;
        map.put(val, 0);
        removeEntry(val);
        return true;
    }

    private void removeEntry(int val) {
        Iterator<Integer> itr = map.keySet().iterator();
        while(itr.hasNext()) {
            if (itr.next() == val) {
                itr.remove();
                break;
            }
        }
    }

    public int getRandom() {
        List<Integer> keyList = new ArrayList<>(map.keySet());
        Random random = new Random();
        int randomValue = random.nextInt(keyList.size());
        return keyList.get(randomValue);
    }

    public static void main(String[] args) {
        Problem380 problem380 = new Problem380();
        System.out.println(problem380.insert(1));
        System.out.println(problem380.remove(2));
        System.out.println(problem380.insert(2));
        System.out.println(problem380.getRandom());
        System.out.println(problem380.remove(1));
        System.out.println(problem380.insert(2));
        System.out.println(problem380.getRandom());
    }
}
