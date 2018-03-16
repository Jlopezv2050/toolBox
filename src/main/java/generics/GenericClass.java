package generics;

import java.util.List;

/**
 * <T extends List> says that the class has available a generic type that extends from list.
 * Comparable <GenericClass<T>> we are using T for first time.
 * */
public class GenericClass <T extends List> implements Comparable <GenericClass<T>> {

    private T myList;

    public GenericClass(T initialList){
        this.myList = initialList;
    }

    public void printMyList(){
        for(Object item: myList){
            System.out.println(item);
        }
    }

    @Override
    public int compareTo(GenericClass<T> o) {
        return 0;
    }
}

