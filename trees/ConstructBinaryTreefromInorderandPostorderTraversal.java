package trees;

import javax.swing.tree.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        return buildTree(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, 
                               int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        
        // The last element in postorder traversal is the root node.
        TreeNode root = new TreeNode(postorder[postEnd]);
        
        // Find the root in inorder traversal to separate left and right subtrees.
        int inRootIndex = inStart;
        while (inRootIndex <= inEnd && inorder[inRootIndex] != root.val) {
            inRootIndex++;
        }
        
        // Number of nodes in the left subtree
        int leftTreeSize = inRootIndex - inStart;
        
        // Recursively construct the left subtree
        root.left = buildTree(inorder, inStart, inRootIndex - 1, 
                              postorder, postStart, postStart + leftTreeSize - 1);
        
        // Recursively construct the right subtree
        root.right = buildTree(inorder, inRootIndex + 1, inEnd, 
                               postorder, postStart + leftTreeSize, postEnd - 1);
        
        return root;
    }
}

}
