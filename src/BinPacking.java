import java.util.LinkedList;

import java.util.List;
import java.util.Queue;

public class BinPacking {
    static List<Item> insertedList = new LinkedList<Item>();

    public static void main(String[] args) {
        Queue<Item> queue = new LinkedList<Item>();
        /*queue.add(new Item(0.85));
        queue.add(new Item(0.5));
        queue.add(new Item(0.4));
        queue.add(new Item(0.4));
        queue.add(new Item(0.3));
        queue.add(new Item(0.2));
        queue.add(new Item(0.2));
        queue.add(new Item(0.1));*/

       queue.add(new Item(0.7));
        queue.add(new Item(0.7));
        queue.add(new Item(0.5));
        queue.add(new Item(0.4));
        queue.add(new Item(0.4));
        queue.add(new Item(0.3));
        queue.add(new Item(0.1));
        queue.add(new Item(0.1));
        List<Bin> binList = new LinkedList<>();
        binList.add(new Bin());
        binList.add(new Bin());
        binList.add(new Bin());
        binList.add(new Bin());

        while (!queue.isEmpty()) {
            Item item = queue.remove();
            while (!insertedList.contains(item) && (binList.get(0).open == true || binList.get(1).open == true || binList.get(2).open == true || binList.get(3).open == true)) {
                for (int i = 0; i < binList.size(); i++) {
                    if (binList.get(i).open == true) {
                        Bin bin = binList.get(i);

                        if (bin.volume - item.size >= 0) {
                            bin.list.add(item);
                            bin.volume = bin.volume - item.size;
                            insertedList.add(item);
                            break;
                        }
                    }
                }
                break;
            }
            if (!insertedList.contains(item)) {
                Bin bin = null;
                for (int i = 0; i < binList.size(); i++) {
                    if (binList.get(i).open == false) {
                        bin = binList.get(i);
                        bin.open = true;
                        break;
                    }
                }
                if (bin.volume - item.size >= 0) {
                    bin.list.add(item);
                    bin.volume = bin.volume - item.size;
                    insertedList.add(item);
                }
            }

        }
        for (int j = 0; j < binList.size(); j++) {
            System.out.print("Bin#" + (j + 1) + " = ");
            for (int k = 0; k < binList.get(j).list.size(); k++) {
                System.out.print(binList.get(j).list.get(k).size + " ");
            }
            System.out.println();
        }
    }
}

class Bin {
    double volume = 1.0;
    List<Item> list = new LinkedList<Item>();
    boolean open = false;
}
class Item{
    double size;
    public Item(double v) {
        size=v;
    }
}