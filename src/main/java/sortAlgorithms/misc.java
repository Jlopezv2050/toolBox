package sortAlgorithms;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class misc {
    public static void bubbleSort(List<? extends Number> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).doubleValue() > list.get(i).doubleValue()) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> listToOrder = new ArrayList<>();
        listToOrder.add(1);
        listToOrder.add(5);
        listToOrder.add(3);
        listToOrder.add(8);

        bubbleSort(listToOrder);

        System.out.println("hello");
    }
}
