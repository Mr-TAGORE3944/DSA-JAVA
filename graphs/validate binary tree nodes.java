import java.util.HashSet;
import java.util.Set;

public class ValidateBinaryTreeNodes {

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        int[] inDegree = new int[n];  // Array to store in-degrees of nodes

        // Calculate in-degrees by counting how many times each node is a child
        for (int i = 0; i < n; i++) {
            if (leftChild[i] != -1) {
                inDegree[leftChild[i]]++;
                if (inDegree[leftChild[i]] > 1) {
                    return false;  // A node with more than one parent
                }
            }
            if (rightChild[i] != -1) {
                inDegree[rightChild[i]]++;
                if (inDegree[rightChild[i]] > 1) {
                    return false;  // A node with more than one parent
                }
            }
        }

        // Find the root (the node with in-degree 0)
        int root = -1;
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                if (root == -1) {
                    root = i;  // Found the root
                } else {
                    return false;  // More than one root
                }
            }
        }

        if (root == -1) {
            return false;  // No root found
        }

        // Check if all nodes are reachable from the root
        Set<Integer> visited = new HashSet<>();
        if (!dfs(root, leftChild, rightChild, visited)) {
            return false;
        }

        // Check if all nodes were visited
        return visited.size() == n;
    }

    // DFS helper method to traverse the tree
    private boolean dfs(int node, int[] leftChild, int[] rightChild, Set<Integer> visited) {
        if (visited.contains(node)) {
            return false;  // Cycle detected
        }

        visited.add(node);  // Mark the node as visited

        // Traverse the left child
        if (leftChild[node] != -1) {
            if (!dfs(leftChild[node], leftChild, rightChild, visited)) {
                return false;
            }
        }

        // Traverse the right child
        if (rightChild[node] != -1) {
            if (!dfs(rightChild[node], leftChild, rightChild, visited)) {
                return false;
            }
        }

        return true;  // No cycles found
    }

    // Main method for testing
    public static void main(String[] args) {
        ValidateBinaryTreeNodes solution = new ValidateBinaryTreeNodes();

        // Test case 1
        int n = 4;
        int[] leftChild = {1, -1, 3, -1};
        int[] rightChild = {2, -1, -1, -1};
        System.out.println(solution.validateBinaryTreeNodes(n, leftChild, rightChild));  // Output: true

        // Test case 2
        int[] leftChild2 = {1, -1, 3, -1};
        int[] rightChild2 = {2, 3, -1, -1};
        System.out.println(solution.validateBinaryTreeNodes(4, leftChild2, rightChild2));  // Output: false
    }
}
