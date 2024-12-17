package trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class AverageLevelsBinaryTree {

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            List<Double> ld = new LinkedList<>();
            if (root == null)
                return ld;
            Queue<TreeNode> q = new LinkedList<>();
            // performing Bfs on given root node
            // in BFS we use the Queue, Dfs we use Stack;
            // by this we can conclude that , we performing the BFS on given root Node ;
            q.add(root);
            while (!q.isEmpty()) {
                int levelSize = q.size();
                double sum = 0;
                int cnt = 0;
                for (int i = 0; i < levelSize; i++) {
                    TreeNode currNode = q.poll();
                    sum += currNode.val;
                    cnt++;
                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }
                ld.add(sum / cnt);
                sum = 0;
                cnt = 0;
            }

            return ld;
        }
    }
}
