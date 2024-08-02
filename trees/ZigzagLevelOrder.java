package trees;
import java.util.*;

public class ZigzagLevelOrder {
    
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
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new LinkedList<>();
            if (root == null) return result;
    
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean leftToRight = true;
    
            while (!queue.isEmpty()) {
                int levelSize = queue.size();
                LinkedList<Integer> currentLevel = new LinkedList<>();
    
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();
    
                    if (leftToRight) {
                        currentLevel.add(currentNode.val);
                    } else {
                        currentLevel.addFirst(currentNode.val);
                    }
    
                    if (currentNode.left != null) {
                        queue.add(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        queue.add(currentNode.right);
                    }
                }
    
                result.add(currentLevel);
                leftToRight = !leftToRight;
            }
    
            return result;
        }
    }
    

import javax.swing.tree.TreeNode;
}
