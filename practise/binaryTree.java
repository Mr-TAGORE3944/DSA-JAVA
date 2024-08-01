package practise;

public class binaryTree {
    

    public static class Node {
        int data ;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
        
    }

    public static class Binarytree {
        static int idx = -1;
        public static Node buildTree(int[] nodes){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
        
    }



    public static void preOrder(Node root){
        if(root == null) return;
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
 

    }

    public static void Inorder(Node root){
        if(root == null) return ;
        Inorder(root.left);
        System.out.println(root.data);
        Inorder(root.right);
    }

        public static void PostOrder(Node root){
        if(root == null) return ;
        Inorder(root.left);
        Inorder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args) {

        int[] nodes = {1 , 2 , 4 , -1 , -1 , 5 , -1 , -1 ,3 -1 , 6 , -1 , -1};

        Binarytree tree = new Binarytree();
        Node root = Binarytree.buildTree(nodes);
        System.out.println(root.data);
        preOrder(root);
        
    }
}
