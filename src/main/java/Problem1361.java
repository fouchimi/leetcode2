
public class Problem1361 {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegrees = new int[n];

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) inDegrees[leftChild[i]]++;
            if (rightChild[i] != -1) inDegrees[rightChild[i]]++;
        }

        int rootNode = 0, zeroInDegreeNodes = 0;
        for (int i = 0; i < n; i++) {
            if (inDegrees[i] == 0) {
                rootNode = i;
                zeroInDegreeNodes++;
            }
            // All nodes except root node should have in-degree of one
            if (inDegrees[i] > 1 || zeroInDegreeNodes > 1) return false;
        }

        // There should be exactly one node with in-degree 1 and that node should be root node
        if (zeroInDegreeNodes == 0) return false;

        // Created visited array
        boolean[] visited = new boolean[n];
        // If there is multiple components some nodes will be marked as unvisited
        dfs(rootNode, visited, leftChild, rightChild);

        for (int i = 0; i < n; i++) {
            if (!visited[i]) return false;
        }

       return true;
    }

    private void dfs (int root, boolean[] visited, int[] leftChild, int[] rightChild) {
        visited[root] = true;
        if (leftChild[root] != -1) dfs(leftChild[root], visited, leftChild, rightChild);
        if (rightChild[root] != -1) dfs(rightChild[root], visited, leftChild, rightChild);
    }


    public static void main(String[] args) {
        Problem1361 problem1361 = new Problem1361();
        System.out.println(problem1361.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,-1,-1,-1}));
        System.out.println(problem1361.validateBinaryTreeNodes(4, new int[]{1,-1,3,-1}, new int[]{2,3,-1,-1}));
    }
}
