package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sequences of computations steps chain together (predicates, functions, consumers...)
 * A sequence of elements supporting sequential and parallel aggregate operations.
 * Set of an object references
 * */
public class Streams {

//Methods references
//You use lambda expressions to create anonymous methods.
// Sometimes, however, a lambda expression does nothing but call an existing method.
// In those cases, it's often clearer to refer to the existing method by name.
public static void main(String[] args) {
    List<String> someBingoNumbers = Arrays.asList(
            "N40", "N36",
            "B12", "B6",
            "G53", "G49", "G60", "G50", "g64",
            "I26", "I17", "I29",
            "O71");

    //Is effectively final so you can use inside lambda
    List<String> gNumbers = new ArrayList<>();

//        someBingoNumbers.forEach(number -> {
//            if(number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });

//BINGO NUMBERS LIST WONT'T BE CHANGED WHEN WORK STREAMS.
//STREAM OPERATIONS:
    //HAVE TO BE NON-INTERFERING (DON'T CHANGE THE STREAM SOURCE)
    //MUST BE STATELESS ( RESULT OF AN OPERATION CANT'T DEPEND ON ANY STATE OUTSIDE OF THE OPERATION EX. DEPEND ON VARIABLE VALUE IN PREVIOUS STEP)




//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach((String s) -> System.out.println(s));



    someBingoNumbers
            .stream()
            .map(String::toUpperCase)
            //there is no way for the compiler to know that the argument shoud be G
            .filter(s->s.startsWith("G"))
            .sorted()
            .forEach(System.out::println);

}
}

