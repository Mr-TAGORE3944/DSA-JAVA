package trees;

import java.util.*;

import backtracking.printPermutations;

public class implementation_of_trees {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            data = val;
            this.left = null;
            this.right = null;
        }
    }

    public static class BinaryTree {
        static int idx = -1;
        public static Node buildTree(int[] nodes) {
            idx++;
            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    public static void preOrder(Node root) {
        if (root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void Inorder(Node root) {
        if (root == null) return;
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);
    }

    public static void PostOrder(Node root) {
        if (root == null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.data);
    }

    public static void levelOrder(Node root) {
        if (root == null) return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    public static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCnt = countNodes(root.left);
        int rightCnt = countNodes(root.right);
        return leftCnt + rightCnt + 1;
    }

    public static int sumNodes(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCnt = sumNodes(root.left);
        int rightCnt = sumNodes(root.right);
        return leftCnt + rightCnt + root.data;
    }

    public static int height(Node root) {
        if (root == null) return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int myheight = Math.max(leftHeight, rightHeight) + 1;
        return myheight;
    }

    public static int diameter(Node root) {
        if (root == null) return 0;
        int dia1 = diameter(root.left);
        int dia2 = diameter(root.right);
        int dia3 = height(root.left) + height(root.right);
        return Math.max(dia3, Math.max(dia2, dia1));
    }
    public static class TreeInfo {
        int ht;
        int dia;
        TreeInfo(int ht , int dia){
            this.ht = ht;
            this.dia = dia;
        }
        
    }
    public static TreeInfo diameter2(Node root){
        if(root == null) {
            return new TreeInfo(0,0);
        }
        
        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int myheight = left.ht + right.ht + 1;

        int dia1 = left.dia;
        int dia2 = right.dia;
        int dia3 = left.ht + right.ht +1;
        int mydia = Math.max(dia3, Math.max(dia1, dia2));
        TreeInfo myInfo = new TreeInfo(myheight, mydia);
        return myInfo;

    }

    public static int kthLevelSum(Node root , int level){
        if(root == null) return 0;
        int cnt = 0 , sum = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        cnt++;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    cnt++;
                }
            }else{
                if(cnt == level){
                    sum += currNode.data;
                }
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
        return sum;
    }

    


        public static ArrayList kthLargestLevelSum(Node root , int level){
        if(root == null) return null;
        int cnt = 0 , sum = 0;
        ArrayList<Integer> ll = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        cnt++;
        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                ll.add(sum);
                sum = 0;
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                    cnt++;
                }
            }else{
                
                    sum += currNode.data;
                    
                
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
         Collections.sort(ll, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1; // For descending order
            }
        });
        return ll;
    }

    

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        preOrder(root);
        System.out.println();
        Inorder(root);
        System.out.println();
        PostOrder(root);
        System.out.println();

        System.out.println(diameter2(root).dia);
        ArrayList cnt = kthLargestLevelSum(root , 1);
        System.out.println(cnt.get(0));

    }
}
