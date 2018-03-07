/*

import java.util.ArrayList;
import java.util.List;

public class TimeComplexityForMirror {
    public static List<Project4.Node> list = new ArrayList<>();
    public static void main(String[] args) {
          String array[] = new String[6000000];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i + 1);
        }
        TimeComplexityForMirror mirror=new TimeComplexityForMirror();
        mirror.createTree(array);

        long startForComplete = System.currentTimeMillis();

*/
/* convert tree to its mirror *//*


        mirror.mirror(list.get(0));
        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete);//calculate duration time(unit ms)
        System.out.println("Cost Time is " + cost_timeForComplete + " ms");
    }
    public void createTree(String[] array) {
        for (int i = 0; i < array.length; i++) {
            Project4.Node node = new Project4.Node(array[i]);
            list.add(node);
        }
        // build binary tree
        if (list.size() > 0) {
            for (int i = 0; i < list.size() / 2 - 1; i++) {       // i is the index
                if (list.get(2 * i + 1) != null) {
                    // left node
                    list.get(i).left = list.get(2 * i + 1);
                } else {
                    list.get(i).left = new Project4.Node(null);
                    list.add(2 * i + 1, list.get(i).left);
                }
                if (list.get(2 * i + 2) != null) {
                    // right node
                    list.get(i).right = list.get(2 * i + 2);
                } else {
                    list.get(i).right = new Project4.Node(null);
                    list.add(2 * i + 2, list.get(i).right);
                }
            }

            int lastIndex = list.size() / 2 - 1;
            list.get(lastIndex).left = list.get(lastIndex * 2 + 1);

            if (list.size() % 2 == 1) {
                list.get(lastIndex).right = list.get(lastIndex * 2 + 2);
            }
        }
    }
    Project4.Node mirror(Project4.Node node) {
        if (node == null) {
            return node;
        }



*/
/* do the subtrees *//*


        Project4.Node left = mirror(node.left);
        Project4.Node right = mirror(node.right);


*/
/* swap the left and right pointers *//*


        node.left = right;
        node.right = left;

        return node;
    }
}

class Node {
    String data;
    Project4.Node left, right;

    public Node(String item) {
        data = item;
        left = right = null;

    }
}


*/
