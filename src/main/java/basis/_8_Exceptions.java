package basis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * "event that disrupts the normal program's flow"
 * <p>
 *     Ways to dealing errors
 * 1. LBYL (Look Before You Leap. ej. Test an object is not null before to attempt to use it)
 * 2. EAFP (Easy to Ask for Forgiveness than Permission) ej. Perform the operation then respond the Exception
 *
 * 1. Read int from Scanner. LBYL foreach digit do Character.isDigit(). Better use try catch with mismatchException.
 * 2. Check key in a Map. EAFP is too much code. Use LBYL (getOrDefault()) instead.
 *
 */
public class _8_Exceptions {
    int a = 1;

    //                                                |  Throwable
    //                                                |      |
    //                                                |      |
    //              ----------------------------------|-------------------------
    //              |                                 |                        |
    //              |                                 |                        |
    //  Error (app shouldn't want to catch/handle)    |                    Exception
    //         OutOfMemoryError                       |                        |
    //         StackOverflowError                     |                        |
    //         VirtualMachineError                    |                        |
    //         NoClassDefFoundError                   |                        |
    //                             -------------------|--------------------------------
    //                             |                  |        |                      |
    //                      RuntimeException          |  IOException             User defined
    //                             |                  |  InterruptedException    Exceptions
    //                             |                  |  TimeOutException
    //                             |                  |  EOFException
    //            --------------------------          |  FileNotFoundException
    //            |                        |          |  ClassNotFoundException
    //  NullPointerException          User defined    |  SQLException
    //  IndexOutOfBoundsException   Runtime-Exceptions|
    //  ArithmeticException                           |
    //  IllegalArgumentException                      |
    //                                                |
    //  UNCHECKED (CAN'T PREVENT ( runtime ),         |  CHECKED( CAN prevent (compile time not runtime),
    //  CAUGHT or MAY THROWN                          |  CAUGHT OR MUST THROWN)

    // CHECKED or UNCHECKED means whether it is forced to handle at compile time or it will only be identified at runtime.

    // WHY NOT CATCH THROWABLE
    //Throwable covers Error as well and that's usually no point of return. You don't want to catch/handle that,
    //you want your program to die immediately so that you can fix it properly

    // UNCHECKED are programmatic runtime errors while ERRORS are runtime environment problems not recoverable.

    // THROW EARLY CATCH LATE. Climb the stack trace until the level you reach enough abstraction to handle the problem.

    // Each THREAD has its own call stack. Naming the thread is a good practice in order to identify in the 1st log line.

    public static void main(String[] args) {
        readFile();
        throwFromFinally();
        testMultipleException();

        try {
            avoidLostWrappingExceptions();
        //Catch specific subclasses and never Throwable  because errors also extend Throwable and must not be handed
        } catch (_8_b_User_Defined_Exceptions e) {
            e.printStackTrace();
            System.out.println("method has failed");
        }
    }

    /**
     * try-with-resource statement
     * statement it should implement AutoCloseable (close() gets invoked automatically at runtime)
     * you can declare more than one class in statement (close will be in reverse order)
     * is implicitly declared as final and instantiated just before the start of try
     */
    private static void readFile() {
        try (FileReader fr = new FileReader("\\tmp\\test.txt")) {
            char[] a = new char[50];
            if (fr.read(a)==1) {
                for (char c : a) System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void avoidLostWrappingExceptions() throws _8_b_User_Defined_Exceptions {
        File file = new File("noExist.txt");
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(file);
            System.out.println(fileInputStream.read());
        //You can wrap the exceptions and throw yours
        } catch (IOException e) {
            //Pass the throwable to not lost the stack trace
            throw new _8_b_User_Defined_Exceptions("user msg", e);
        }
    }

    private static void testMultipleException() {
        try {
            int[] a = {0, 1};
            System.out.println("The value from the third position is: " + a[1]);

        } catch (ArithmeticException | IndexOutOfBoundsException e) {
            System.out.println("ERROR: " + e);
        }
    }

    //The exception from the first method is lost (NO THROW FROM FINALLY
    private static void throwFromFinally(){
       try{
           throwRuntime();
       }finally {
           throwRuntime2();
       }
    }
    //RuntimeException are NOT forced to catch/handle
    private static void throwRuntime(){
        throw new RuntimeException("runtimeException");
    }
    private static void throwRuntime2(){
        throw new RuntimeException("runtimeException2");
    }

}