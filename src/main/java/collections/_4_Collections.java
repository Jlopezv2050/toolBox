package collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Collections.sort (mergeSort (memory consumption instead of CPU)
 * Collections.binarySort
 * Collections.shuttle (semi random)
 * Collections.min/max (compareTo based)
 * Collections.swap
 * Collections.reverse
 */
public class _4_Collections {
    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();

        originalList.add(1);
        originalList.add(2);
        originalList.add(3);

        List<Integer> copiedList = new ArrayList<>(originalList);

        copiedList.set(2, 5);
        copiedList.add(3,7);

        System.out.println(originalList.get(3));
        System.out.println(copiedList.get(3));

    }
}
