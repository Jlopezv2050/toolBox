package collections;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * The implementations of Collections interface have binary search algorithm statically exposed.
 * ¡¡the class has to be ordered!!
 * */

public class _3_BinarySearch {

    public static void main(String[] args) {
        List<Integer> list2try = new Vector<>();
        list2try.add(1);
        list2try.add(2);
        list2try.add(6);
        list2try.add(7);
        list2try.add(5);
        list2try.add(2);
        list2try.add(3);

        Collections.sort(list2try);
        list2try.forEach(System.out::println);
        Integer found = Collections.binarySearch(list2try,1);
    }
}
