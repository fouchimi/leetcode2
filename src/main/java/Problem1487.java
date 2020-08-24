import java.util.*;

public class Problem1487 {
    public String[] getFolderNames(String[] names) {
        Set<String> used = new HashSet<>();
        String[] res = new String[names.length];
        Map<String, Integer> next = new HashMap<>();
        int n = names.length;
        for(int i = 0; i < n; i++) {
            String name = names[i];
            if (used.contains(name)) {
                if (!next.containsKey(name)) next.put(name, 1);
                while (used.contains(generate(name, next.get(name)))) next.put(name, next.get(name) + 1);
                String newName = generate(name, next.get(name));
                used.add(newName);
                res[i] = newName;
                next.put(name, next.get(name) + 1);
            } else {
                res[i] = name;
                used.add(name);
            }
        }
        return res;
    }

    private String generate(String prefix, int num) {
        return prefix + "(" + num + ")";
    }

    public static void main(String[] args) {
        Problem1487 problem1487 = new Problem1487();
//        problem1487.getFolderNames(new String[]{"pes","fifa","gta","pes(2019)"});
        problem1487.getFolderNames(new String[]{"gta","gta(1)","gta","avalon"});
        problem1487.getFolderNames(new String[]{"onepiece","onepiece(1)","onepiece(2)","onepiece(3)","onepiece"});
        problem1487.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)"});
        problem1487.getFolderNames(new String[]{"kaido","kaido(1)","kaido","kaido(1)","kaido(2)"});
    }
}
