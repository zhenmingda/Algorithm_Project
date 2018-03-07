package Project4;

import Project4.Node;

public class CheckMirror {
    public static void main(String[] args) {

/* Project4.Node a = new Project4.Node("3");
        Project4.Node b = new Project4.Node("3");
        a.left = new Project4.Node("9");
        a.right = new Project4.Node("20");
        a.right.left=new Project4.Node("15");
        a.right.right=new Project4.Node("7");

        b.left = new Project4.Node("20");
        b.right = new Project4.Node("9");
        b.left.left = new Project4.Node("7");
        b.left.right = new Project4.Node("15");
      */




/* Project4.Node a = new Project4.Node("5");
        Project4.Node b = new Project4.Node("5");
        a.left = new Project4.Node("14");
        a.right = new Project4.Node("15");
        a.left.right = new Project4.Node("3");
        a.right.left=new Project4.Node("6");
        a.right.right=new Project4.Node("9");
        a.left.right.left = new Project4.Node("1");


        b.left = new Project4.Node("15");
        b.right = new Project4.Node("14");
        b.left.left = new Project4.Node("9");
        b.left.right = new Project4.Node("6");
        b.right.left = new Project4.Node("3");

        b.left.right.right = new Project4.Node("1");
     */


        Node a = new Node("3");
        Node b = new Node("3");
        a.left = new Node("20");
        a.right = new Node("9");

        a.right.left = new Node("1");
        a.right.right = new Node("5");

        a.right.left.left = new Node("2");
        a.right.left.right = new Node("4");

        a.right.left.left.left = new Node("15");


        b.left = new Node("9");
        b.right = new Node("20");
        b.left.left = new Node("5");
        b.left.right = new Node("1");

        b.left.right.left = new Node("4");
        b.left.right.right = new Node("2");
        b.left.right.left.right = new Node("15");


        if (areMirror(a, b) == true)
            System.out.println("Yes,Project4.Mirror image");
        else
            System.out.println("No,Not Project4.Mirror image");
    }


    static boolean areMirror(Node a, Node b) {

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
}

