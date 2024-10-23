import java.util.ArrayList;
import java.util.List;

public class UniqueBinarySearchTreesII {

    // Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        // Base case: if start > end, there should be no nodes in this subtree.
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Iterate over all values to make each one the root.
        for (int i = start; i <= end; i++) {
            // Generate all left and right subtrees recursively.
            List<TreeNode> leftTrees = generateSubtrees(start, i - 1);
            List<TreeNode> rightTrees = generateSubtrees(i + 1, end);

            // Combine left and right subtrees with the current node as root.
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = left;
                    currentTree.right = right;
                    allTrees.add(currentTree);
                }
            }
        }

        return allTrees;
    }

    // Helper method to print the tree (inorder traversal)
    public void printTree(TreeNode root) {
        if (root == null) return;
        printTree(root.left);
        System.out.print(root.val + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII solution = new UniqueBinarySearchTreesII();
        List<TreeNode> trees = solution.generateTrees(3);

        // Print all unique BSTs.
        for (int i = 0; i < trees.size(); i++) {
            System.out.println("Tree " + (i + 1) + ": ");
            solution.printTree(trees.get(i));
            System.out.println();
        }
    }
}
