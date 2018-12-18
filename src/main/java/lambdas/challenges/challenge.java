package lambdas.challenges;

import java.util.function.Function;
import java.util.function.Supplier;

public class challenge {

    public static void main(String[] args) {
        //CHALLENGE 1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part: parts) {
                    System.out.println(part);
                }
            }
        };

        //SOLUTION
        Runnable runnableLambda = () -> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for (String part: parts) {
                System.out.println(part);
            }
        };


        //CHALLENGE 2
        Function<String,String> everySecondChar = s -> {
            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if ( i % 2 == 1) {
                    returnVal.append(s.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondChar.apply("hola"));

        //CHALLENGE 6
        Supplier<String> iLoveJava = () -> "I love Java";

        String supplierResutl = iLoveJava.get();


    }

    public static String everySecondChar(String source) {
        StringBuilder returnVal = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if ( i % 2 == 1) {
                returnVal.append(source.charAt(i));
            }
        }
        return returnVal.toString();
    }

    public static void everySecondCharacter (Function<String,String> function, String toApply){
        function.apply(toApply);
    }
}
