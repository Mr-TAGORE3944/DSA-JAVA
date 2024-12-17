package trees;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.tree.TreeNode;

public class KthSmallestElementinBST {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    // O(nlogn);

    class Solution {
        public static void fillVal(TreeNode root, ArrayList<Integer> result) {
            if (root == null)
                return;
            result.add(root.val);
            fillVal(root.left, result);
            fillVal(root.right, result);
        }

        public int kthSmallest(TreeNode root, int k) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null)
                return 0;
            fillVal(root, result);
            Collections.sort(result);
            return result.get(k - 1);
        }
    }
}
