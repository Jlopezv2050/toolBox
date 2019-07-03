package generics;

import java.util.Collections;
import java.util.List;

/**
 * <T extends List> says that the class has available a generic type that extends from list.
 * when you say class<T> you're saying T is "available"
 * public int compareTo(GenericClass<T>)
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



/*

Why super keyword in generics is not allowed at class level

The super bound is not allowed in class definition.

//this code does not compile !
class Forbidden<X super Vehicle> { }
Why? Because such construction doesn't make sense. For example, you can't erase the type parameter with Vehicle because
the class Forbidden could be instantiated with Object. So you have to erase type parameters to Object anyway. If think
about class Forbidden, it can take any value in place of X, not only superclasses of Vehicle. There's no point in using
super bound, it wouldn't get us anything. Thus it is not allowed.

*/

