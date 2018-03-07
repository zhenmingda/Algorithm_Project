package Project4;// Java program to convert binary tree into its mirror


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* Class containing left and right child of current
   node and key value*/


public class BinaryTree {
    public static List<Node> list = new ArrayList<>();
    Node a, b;

    /* Given two trees, return true if they are
       mirror of each other */
    boolean areMirror(Node a, Node b)
    {
        /* Base case : Both empty */
        if (a == null && b == null)
            return true;

        // If only one is empty
        if (a == null || b == null)
            return false;

        /* Both non-empty, compare them recursively
           Note that in recursive calls, we pass left
           of one tree and right of other tree */
        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }
    public void createTree(String[] array) {
        for (int i = 0; i < array.length; i++) {
            Node node = new Node(array[i]);
            list.add(node);//创建结点，每一个结点的左结点和右结点为null

            // list中存着每一个结点
        }


        // 构建二叉树
        if (list.size() > 0) {
            for (int i = 0; i < list.size() / 2 - 1; i++) {       // i表示的是根节点的索引，从0开始
                if (list.get(2 * i + 1) != null) {
                    // 左结点
                    list.get(i).left = list.get(2 * i + 1);
                } else {
                    list.get(i).left = new Node(null);
                    list.add(2 * i + 1, list.get(i).left);
                }
                if (list.get(2 * i + 2) != null) {
                    // 右结点
                    list.get(i).right = list.get(2 * i + 2);
                } else {
                    list.get(i).right = new Node(null);
                    list.add(2 * i + 2, list.get(i).right);
                }
            }
            // 判断最后一个根结点：因为最后一个根结点可能没有右结点，所以单独拿出来处理
            int lastIndex = list.size() / 2 - 1;
            // 左结点
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);
            // 右结点，如果数组的长度为奇数才有右结点
            if (list.size() % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
    }


    Node root;

    void mirror() {
        root = mirror(list.get(0));
    }

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
        BinaryTree tree = new BinaryTree();
        /*tree.root = new Node("3");
        tree.root.left = new Node("9");
        tree.root.left.left = new Node(null);
        tree.root.left.right = new Node(null);
        tree.root.right = new Node("20");
        tree.root.right.left = new Node("15");
        tree.root.right.right = new Node("7");*/



        /*tree.root = new Node("5");
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
        tree.root.right.right.right = new Node(null);*/


      /*  tree.root = new Node("3");
        tree.root.left = new Node("20");
        tree.root.left.left = new Node(null);
        tree.root.left.right = new Node(null);

        tree.root.right = new Node("9");
        tree.root.right.left = new Node("1");
        tree.root.right.left.left = new Node("2");
        tree.root.right.left.left.left = new Node("15");
        tree.root.right.left.left.right = new Node(null);


        tree.root.right.left.right = new Node("4");
        tree.root.right.left.right.left = new Node(null);
        tree.root.right.left.right.right = new Node(null);
        tree.root.right.right = new Node("5");
        tree.root.right.right.left = new Node(null);
        tree.root.right.right.right = new Node(null);*/
        String array[] = new String[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i + 1);
        }
        tree.createTree(array);
        /* print inorder traversal of the input tree */


        System.out.println("Breadth traversal of input tree is :");

       // tree.levelOrderTraversal(list.get(0));
        System.out.println("");

        long startForComplete = System.currentTimeMillis();
        /* convert tree to its mirror */
        tree.mirror();
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete);//calculate duration time(unit ms)
        System.out.println("Cost Time is " + cost_timeForComplete + " ms");
        /* print inorder traversal of the minor tree */
        System.out.println("Breadth traversal of Mirror input tree is :");

        //tree.levelOrderTraversal(list.get(0));
        System.out.println("");
        Node a = new Node("1");
        Node b = new Node("1");
        a.left = new Node("2");
        a.right = new Node("3");
        a.left.left = new Node("4");
        a.left.right = new Node("5");

        b.left = new Node("3");
        b.right = new Node("2");
        b.right.left = new Node("5");
        b.right.right = new Node("4");

        if (tree.areMirror(a, b) == true)
            System.out.println("Mirror image");
        else
            System.out.println("Not Mirror image");
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