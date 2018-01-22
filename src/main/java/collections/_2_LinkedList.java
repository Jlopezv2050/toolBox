package collections;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Doubled linked queue
 * |100|*-|-------------------> |112|*-|-------------------> |104|*-|
 *
 * ARRAYLIST vs LINKEDLIST
 *
 * ArrayList is the FIRST OPTION (less memory consumption) and best when:
 *  A. GET/SET by index (because the items are directly linked and we don't have to navigate through the links).
 *  B. INSERT/REMOVE at the end (we are not generating a shift)
 *  C. SORT (items are not linked so it's posible to sort by groups...)
 *  D. ITERATE.
 *
 * LinkedList
 *  A. INSERT/REMOVE at first/middle (we don't have to shift as in ArrayList).
 *  B. INSERT/REMOVE iterator.
 *  C. ADD in ORDER.
 *  D. REVERSE ITERATOR.
 *  E. REVERSE complete list using Node class.
 * */
public class _2_LinkedList {

    class Song{
        private String title;

        public Song(String title){
            this.title = title;
        }

        public String getTitle(){
            return this.title;
        }
    }

    public static void reproduccionInversa(List<Song> listaReproducion){
        listaReproducion.stream()
                .map(Song::getTitle)
                .collect(Collectors.toCollection(LinkedList::new))
                .descendingIterator()
                .forEachRemaining(System.out::println);
    }

    public static void main(String[] args) {
        List<Song> listaReproducion = new LinkedList<>();
        _2_LinkedList linkedListClass = new _2_LinkedList();

        Song cancionPop = linkedListClass.new Song("volver a empezar");
        Song cancionPop2 = linkedListClass.new Song("orejas rojas");
        Song cancionPop3 = linkedListClass.new Song("tirando");
        listaReproducion.add(cancionPop);
        listaReproducion.add(cancionPop2);
        listaReproducion.add(cancionPop3);

        reproduccionInversa(listaReproducion);
    }
}