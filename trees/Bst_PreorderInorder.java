package trees;

import javax.swing.tree.TreeNode;

public class Bst_PreorderInorder {
    

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, 
                               int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        
        // The first element in preorder traversal is the root node.
        TreeNode root = new TreeNode(preorder[preStart]);
        
        // Find the root in inorder traversal to separate left and right subtrees.
        int inRootIndex = inStart;
        while (inRootIndex <= inEnd && inorder[inRootIndex] != root.val) {
            inRootIndex++;
        }
        
        // Number of nodes in the left subtree
        int leftTreeSize = inRootIndex - inStart;
        
        // Recursively construct the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + leftTreeSize, 
                              inorder, inStart, inRootIndex - 1);
        
        // Recursively construct the right subtree
        root.right = buildTree(preorder, preStart + leftTreeSize + 1, preEnd, 
                               inorder, inRootIndex + 1, inEnd);
        
        return root;
    }
}

}
