import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Problem748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, (arg1, arg2) -> {
            int arg1Length = arg1.length(), arg2Length = arg2.length();
            if (arg1Length < arg2Length) return -1;
            else if (arg1Length > arg2Length) return 1;
            else return 0;
        });

        Map<Character, Integer>[] mapArray = getMapArray(words);
        Map<Character, Integer> licenseMap = cleanLicensePlate(licensePlate);

        int index = 0;
        for (Map<Character, Integer> currentMap : mapArray) {
            boolean found = true;
            for (Character licenseKey : licenseMap.keySet()) {
                if (!currentMap.containsKey(licenseKey) || licenseMap.get(licenseKey) > currentMap.get(licenseKey)) {
                    found = false;
                    break;
                }
            }
            if (found) return words[index];
            index++;
        }

        return null;
    }

    private Map<Character, Integer>[] getMapArray(String[] words) {
        int N = words.length, k = 0;
        Map<Character, Integer>[] mapArray = new LinkedHashMap[N];
        for (String word : words) {
            word = word.toLowerCase();
            Map<Character, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            mapArray[k++] = map;
        }
        return mapArray;
    }

    private Map<Character, Integer> cleanLicensePlate(String licensePlate) {
        Map<Character, Integer> map = new HashMap<>();
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            char key = licensePlate.charAt(i);
            if (Character.isLetter(licensePlate.charAt(i))) map.put(key, map.getOrDefault(key, 0) + 1);
        }
        return map;
    }

    public static void main(String[] args) {
        Problem748 problem748 = new Problem748();
        //licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
        //licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
        System.out.println(problem748.shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        System.out.println(problem748.shortestCompletingWord("1s3 456", new String[]{"looks", "pest", "stew", "show"}));
    }
}
