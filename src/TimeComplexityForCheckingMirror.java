/*
import java.util.ArrayList;
import java.util.List;

public class TimeComplexityForCheckingMirror {

    static boolean areMirror(Project4.Node a, Project4.Node b) {


        if (a == null && b == null)
            return true;

        // If only one is empty
        if (a == null || b == null)
            return false;


        return a.data == b.data
                && areMirror(a.left, b.right)
                && areMirror(a.right, b.left);
    }

    public static void main(String[] args) {
        String array[] = new String[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = String.valueOf(i + 1);
        }
        String array1[] = new String[100000];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = String.valueOf(i + 1);
        }
        List list1 = new TimeComplexityForCheckingMirror().createTree(array);
        List list2 = new TimeComplexityForCheckingMirror().createTree(array1);
        long startForComplete = System.currentTimeMillis();
        if (areMirror((Project4.Node) list1.get(0), (Project4.Node) list2.get(0)))
            System.out.println("Yes,Project4.Mirror image");
        else
            System.out.println("No,Not Project4.Mirror image");

        long endForComplete = System.currentTimeMillis();
        long cost_timeForComplete = (endForComplete - startForComplete);
        System.out.println("Cost Time is " + cost_timeForComplete + " ms");

    }

    List createTree(String[] array) {
        List<Project4.Node> list = new ArrayList<Project4.Node>();
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
        return list;
    }
}

*/
/**
 *
 *//*

class Project4.Node {
    String data;
    Project4.Node left, right;

    public Project4.Node(String item) {
        data = item;
        left = right = null;

    }
}*/
