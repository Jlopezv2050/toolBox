package lambdas.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Challenges2 {


    public static void main (String[] args){
        //CHALLENGE 9
        //Print the items in sorted order, upper-cased first letter.

        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Olivia",
                "emily",
                "harry",
                "Jacob"
        );
/*
        long startTime = System.currentTimeMillis();

        List<String> uperCasedList = new ArrayList<>();

        topNames2015
                .forEach(s -> uperCasedList.add((s.substring(0,1).toUpperCase() + s.substring(1))));

//        Comparator<String> compare = (s1, s2)-> {
//            return s1.compareTo(s2);
//        };
        uperCasedList.sort(String::compareTo);
        uperCasedList.forEach(System.out::println);

        long estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println(estimatedTime);

        //CHALLENGE 10 the same than 9 but using streams
        startTime = System.currentTimeMillis();

        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1))
                .sorted()
                .forEach(System.out::println);

        estimatedTime = System.currentTimeMillis() - startTime;

        System.out.println(estimatedTime);

        //CHALLENGE 12 only print the ones starting by A
        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1))
                .filter(s -> s.startsWith("A"))
                .forEach(System.out::println);
*/

        //CHALLENGE 13 we want to debug after do the uppercase to ensure its working
        topNames2015
                .stream()
                .map(s -> s.substring(0,1).toUpperCase()+s.substring(1))
                .peek(System.out::println);

                //PEEK IS NOT A TERMINAL OPERATION!! WON'T PRINT ANYTHING

        //CHALLENGE 14 add a terminal operation

        //My asw -> I've found on the Internet an article searching by: "stream-terminal-operations"
        // for example, count is an terminal operation





    }
}
