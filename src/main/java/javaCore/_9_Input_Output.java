package javaCore;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by juan on 24/11/16.
 */
public class _9_Input_Output {

    /**
     * InputStreamReader
     *
     * Advantages:
     *     The input is buffered for efficient reading.
     * Drawbacks:
     *     The wrapping code is hard to remember.
     * @return name
     */
    private String readUsingInputStreamReader(){
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
     */
    private String readUsingScanner(){
        String nationality = null;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your nationality: ");
        nationality = scanner.nextLine();
        System.out.println("Your nationality is: " + nationality);

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
    private Map<String,String> readUsingConsole(){

        Map result = new HashMap<String, String>();

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
}
