package inputOutput;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _1_Input_Output {
    /**
     * InputStreamReader
     *
     * Advantages:
     *     The input is buffered for efficient reading.
     * Drawbacks:
     *     The wrapping code is hard to remember.
     * @return name
     */
    private static String readUsingInputStreamReader(){
        String name = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter your name: ");

            name = reader.readLine();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return name;
    }

    /**
     * Scanner
     *
     *  Advantages:
     *      Convenient methods for parsing primitives (nextInt(), nextFloat(), …) from the tokenized input.
     *      Regular expressions can be used to find tokens.
     *  Drawbacks:
     *      The reading methods are not synchronized.
     * @return nationality
     *
     * sout "Enter num" INTRO --> you have to do .nextLine() to skip this intro.
     */
    private static String readUsingScanner(){
        String nationality;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your nationality: ");
        nationality = scanner.nextLine();
        System.out.println("Your nationality is: " + nationality);
        scanner.close();

        return nationality;
    }

    /**
     * Console
     *
     *  Advantages:
     *      Reading password without echoing the entered characters.
     *      Reading methods are synchronized.
     *      Format string syntax can be used.
     *  Drawbacks:
     *      Does not work in non-interactive environment (such as in an IDE).
     * @return result
     */
    private static Map<String,String> readUsingConsole(){
        HashMap<String, String> result = new HashMap<>();

        Console console = System.console();
        if (console == null) {
            System.out.println("No console: not in interactive mode!");
            System.exit(0);
        }

        System.out.print("Enter your username: ");
        String username = console.readLine();

        System.out.print("Enter your password: ");
        char[] password = console.readPassword();

        System.out.println("Thank you!");
        result.put("username", username);
        result.put("password", String.valueOf(password));

        return result;
    }

    public static void main(String[] args) {
        System.out.println(readUsingInputStreamReader());
        System.out.println(readUsingScanner());
        System.out.println(readUsingConsole());
    }

}
