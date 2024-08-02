package trees;

import javax.swing.tree.TreeNode;

public class maximumdepth {
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
    public int maxDepth(TreeNode curr) {
        if(curr == null) return 0;
        int left = maxDepth(curr.left);
        int right = maxDepth(curr.right);
        return Math.max(left , right) + 1;

    }
}
}
