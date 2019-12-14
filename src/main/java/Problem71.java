import java.util.ArrayDeque;

public class Problem71 {

    public String simplifyPath(String path) {
        ArrayDeque<String> deque = new ArrayDeque<>();
        char[] chars = path.toCharArray();
        int index = 0;
        while (index < chars.length) {
            String nextDir = this.getNextDir(index, chars);
            index += (nextDir.length() + 1);

            if ("..".equals(nextDir)) {
                if (!deque.isEmpty()) deque.pop();
            } else if (!("".equals(nextDir)) && !(".".equals(nextDir))) deque.push(nextDir);

        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!deque.isEmpty()) {
            stringBuilder.append("/").append(deque.pollLast());
        }
        return stringBuilder.length() == 0 ? "/" : stringBuilder.toString();
    }

    public String getNextDir(int start, char[] chars) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = start + 1; i < chars.length; i++) {
            if (chars[i] == '/') break;
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Problem71 problem71 = new Problem71();
        System.out.println(problem71.simplifyPath("/.."));
        System.out.println(problem71.simplifyPath("/home/"));
        System.out.println(problem71.simplifyPath("/../"));
        System.out.println(problem71.simplifyPath("/home//foo/"));
        System.out.println(problem71.simplifyPath("/a/./b/../../c/"));
        System.out.println(problem71.simplifyPath("/a/../../b/../c//.//"));
        System.out.println(problem71.simplifyPath("/a//b////c/d//././/.."));
        System.out.println(problem71.simplifyPath("/..."));
    }
}
