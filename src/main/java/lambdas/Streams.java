package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Sequences of computations steps chain together (predicates, functions, consumers...)
 * A sequence of elements supporting sequential and parallel aggregate operations.
 * Set of an object references
 */
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

        //this forEach comes from Iterable.java
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
                .stream()  //intermediate operation
                .map(String::toUpperCase) //intermediate operation
                //there is no way for the compiler to know that the argument should be G
                .filter(s -> s.startsWith("G")) //intermediate operation
                .sorted() //intermediate operation
                .forEach(System.out::println); //terminal operation (doesn't have predecessor in the chain)


        //We can declare directly Stream.
        //We have a long chain and we want to debug (print the result of each operation in the chain)
        //forEach is a terminal operation. We use PEEK (receive a consumer)
        //this evaluates the consumer foreach item, then adds item to new Stream
        Stream<String> ioNumberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNumberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNumberStream, inNumberStream);
        System.out.println("-----------------------");
        System.out.println(concatStream
                .distinct()
                .peek(System.out::println)
                .count());

        //----------------------------------------------------------------------------------
        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);


        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        //FlatMap -> accepts an object as a function argument but returns N objects (ex. department -> get employees)
        //is called like this because is used to flatten nested lists
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        //Collect -> store contents at the end of the chain
        System.out.println("---------------");
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                .collect(Collectors.toList());

        //Other way of collect allowing for reuse of collection strategies
        //The arguments are:
        //Supplier -> supplier create object
        //BiConsumer -> accumulator (runtime needs to add a single item to the list)
        //BiConsumer -> combinator (add multiple items and compatible with the accumulator)
        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }

        //Supplied collectors
        Map<Integer, List<Employee>> groupedByAge = departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .collect(Collectors.groupingBy(employee -> employee.getAge()));

        //
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                //youngest employee
                //has an optional result and is a terminal operation
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                //is a non-stream method (comes from Optional)
                .ifPresent(System.out::println);

        //we can't reuse an stream operation once a terminal operation has call (illegal state exception)

        //we can use long, double, ... streams for more concise interfaces

        //Advanced topics
        //parallel streams

        //lazy evaluation (if you wouldn't use count (terminal operation), filter (intermediate op.) wouldn't be executed
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();

    }
}