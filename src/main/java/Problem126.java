import java.util.*;

public class Problem126 {

    public List<List<String>> findLadders (String beginWord, String endWord, List<String> wordList) {
        List<List<String>> resultList = new ArrayList<>();
        if (!wordList.contains(endWord)) return resultList;
        Set<String> dict = new HashSet<>(wordList);
        bfs(beginWord, endWord, dict, resultList);
        return resultList;
    }


    private void bfs(String beginWord, String endWord, Set<String> dict, List<List<String>> resultList) {
        Queue<QueryEntry> queue = new LinkedList<>();
        QueryEntry start = new QueryEntry(beginWord, new ArrayList<>(Arrays.asList(beginWord)));
        queue.offer(start);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        while(!queue.isEmpty()) {
            List<String> newVisited = new ArrayList<>();
            int level = queue.size();
            for(int i = 0; i < level; i++) {
                QueryEntry entry = queue.poll();
                if(entry == null) return;
                String word = entry.word;
                char[] chars = word.toCharArray();
                List<String> path = entry.path;
                for(int j = 0; j < word.length(); j++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        char ch = chars[j];
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            path.add(newWord);
                            resultList.add(path);
                        }
                        if(!visited.contains(newWord) && dict.contains(newWord)) {
                            List<String> tempPath = new ArrayList<>(path);
                            tempPath.add(newWord);
                            queue.offer(new QueryEntry(newWord, tempPath));
                            newVisited.add(newWord);
                        }
                        chars[j] = ch;
                    }
                }
            }
            visited.addAll(newVisited);
            if(!resultList.isEmpty()) return;
        }
    }

    class QueryEntry {
        String word;
        List<String> path;
        QueryEntry(String _word, List<String> _path) {
            this.word = _word;
            this.path = _path;
        }
    }

//    private  Map<String, List<String>> buildGraph(List<String> wordList) {
//        Set<String> set = new HashSet<>(wordList);
//        Map<String, List<String>> res = new HashMap<>();
//        for (String s : wordList) {
//            res.put(s, getNeighbor(set, s));
//        }
//        return res;
//    }
//
//    private  List<String> getNeighbor (Set<String> set, String word) {
//        List<String> res = new ArrayList<>();
//        char[] chs = word.toCharArray();
//        for(int i = 0; i < chs.length; i++) {
//            for(char cur = 'a'; cur <= 'z'; cur++) {
//                if (cur != chs[i]) {
//                    char tmp = chs[i];
//                    chs[i] = cur;
//                    if (set.contains(String.valueOf(chs))) {
//                        res.add(String.valueOf(chs));
//                    }
//                    chs[i] = tmp;
//                }
//            }
//        }
//        return res;
//    }
//
//    private void bfs(String beginWord, String endWord, Map<String, List<String>> graph, List<List<String>> resultList) {
//        List<String> path = new ArrayList<>();
//        path.add(beginWord);
//        Queue<List<String>> queue = new LinkedList<>();
//        queue.offer(path);
//        while(!queue.isEmpty()) {
//            path = queue.poll();
//            String last = path.get(path.size() - 1);
//            if (last.equals(endWord)) {
//                List<String> tempList = new ArrayList<>(path);
//                if (resultList.isEmpty() || (resultList.get(0).size() == tempList.size())) resultList.add(tempList);
//                else break;
//            }
//            for(int i = 0; i < graph.get(last).size(); i++) {
//                if(!path.contains(graph.get(last).get(i))) {
//                    List<String> newPath = new ArrayList<>(path);
//                    newPath.add(graph.get(last).get(i));
//                    queue.offer(newPath);
//                }
//            }
//        }
//    }

    public static void main(String[] args) {
        Problem126 problem126 = new Problem126();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
//        wordList.add("hot");
//        wordList.add("dog");
//        wordList.add("dot");
        List<List<String>> resultList = problem126.findLadders("hit", "cog", wordList);
        for(List<String> list :resultList) {
            System.out.println(list);
        }
    }
}
