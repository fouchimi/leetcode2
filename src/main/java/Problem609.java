import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Problem609 {

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new LinkedHashMap<>();
        for (String path : paths) {
            String[] pathChunks = path.split(" ");
            for (int i = 1; i < pathChunks.length; i++) {
                String currentPath = pathChunks[i];
                int firstParenIndex = currentPath.indexOf('(');
                int secondParenIndex = currentPath.indexOf(')');
                String key = currentPath.substring(firstParenIndex + 1, secondParenIndex);
                map.putIfAbsent(key, new ArrayList<>());
                String filePrefix = currentPath.substring(0, firstParenIndex);
                String directoryPrefix = pathChunks[0] + "/" + filePrefix;
                map.get(key).add(directoryPrefix);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) ans.add(map.get(key));
        }
        return ans;
    }

    public static void main(String[] args) {
        Problem609 problem609 = new Problem609();
        System.out.println(problem609.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }
}
