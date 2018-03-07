
package Project4;// Java program to convert binary tree into its mirror


import java.util.ArrayDeque;




public class MirrorTree {

    Node a, b;
    Node root;

/* Given two trees, return true if they are
       mirror of each other */

    Node mirror(Node node) {
        if (node == null) {
            return node;
        }

 

/* do the subtrees */

        Node left = mirror(node.left);
        Node right = mirror(node.right);
 

/* swap the left and right pointers */

        node.left = right;
        node.right = left;

        return node;
    }



/* testing for example nodes */

    public static void main(String args[]) {


/* creating a binary tree and entering the nodes */

        MirrorTree tree = new MirrorTree();

/* tree.root = new Project4.Node("3");
        tree.root.left = new Project4.Node("9");
        tree.root.left.left = new Project4.Node(null);
        tree.root.left.right = new Project4.Node(null);
        tree.root.right = new Project4.Node("20");
        tree.root.right.left = new Project4.Node("15");
        tree.root.right.right = new Project4.Node("7");*/


        tree.root = new Node("5");
        tree.root.left = new Node("14");
        tree.root.left.left = new Node(null);
        tree.root.left.right = new Node("3");
        tree.root.left.right.left = new Node("1");
        tree.root.left.right.right = new Node(null);
        tree.root.right = new Node("15");
        tree.root.right.left = new Node("6");
        tree.root.right.left.left = new Node(null);
        tree.root.right.left.right = new Node(null);
        tree.root.right.right = new Node("9");
        tree.root.right.right.left = new Node(null);
        tree.root.right.right.right = new Node(null);



      /*  tree.root = new Project4.Node("3");
        tree.root.left = new Project4.Node("20");
        tree.root.left.left = new Project4.Node(null);
        tree.root.left.right = new Project4.Node(null);

        tree.root.right = new Project4.Node("9");
        tree.root.right.left = new Project4.Node("1");
        tree.root.right.left.left = new Project4.Node("2");
        tree.root.right.left.left.left = new Project4.Node("15");
        tree.root.right.left.left.right = new Project4.Node(null);


        tree.root.right.left.right = new Project4.Node("4");
        tree.root.right.left.right.left = new Project4.Node(null);
        tree.root.right.left.right.right = new Project4.Node(null);
        tree.root.right.right = new Project4.Node("5");
        tree.root.right.right.left = new Project4.Node(null);
        tree.root.right.right.right = new Project4.Node(null);*/


        System.out.println("Breadth traversal of input tree is :");

        tree.levelOrderTraversal(tree.root);
        System.out.println("");

        long startForComplete = System.currentTimeMillis();

/* convert tree to its mirror */

        tree.mirror(tree.root);

/* print inorder traversal of the minor tree */

        System.out.println("Breadth traversal of Project4.Mirror input tree is :");

        tree.levelOrderTraversal(tree.root);
        System.out.println("");

    }

    static void levelOrderTraversal(Node root) {

        ArrayDeque<Node> queue = new ArrayDeque<Node>();
        queue.add(root);
        while (queue.isEmpty() == false) {
            Node node = queue.remove();
            System.out.print(String.valueOf(node.data) + "    ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }
}
