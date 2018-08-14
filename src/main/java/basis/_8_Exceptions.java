package basis;

import java.io.FileReader;
import java.io.IOException;

/**
 * "event that disrupts the normal program's flow"
 *
 * LBYL
 * EAFP
 */
public class _8_Exceptions {
    int a= 1;

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


    // WHY NOT CATCH THROWABLE
    //Throwable covers Error as well and that's usually no point of return. You don't want to catch/handle that,
    //you want your program to die immediately so that you can fix it properly

    protected void testException (){
        try {
            int[] a = {0,1};

            System.out.println("El valor de la tercera posicion es: " + a[3]);

        } catch(ArithmeticException | IndexOutOfBoundsException e){

            System.out.println("ERROR: " + e);

        }
    }

    /**
     * try-with-resource statement
     * statement it should implement AutoCloseable (close() gets invoked automatically at runtime)
     * you can declare more than one class in statement (close will be in reverse order)
     * is implicitly declared as final and instantiated just before the start of try
     */
    protected void readFile (){
        try(FileReader fr = new FileReader("\\tmp\\test.txt")){

            try{

            }catch(Exception e){

            }
            char [] a = new char[50];
            fr.read(a);
            for(char c : a)
                System.out.print(c);
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Trow user defined Exceptions
     */
    protected void exceptionMethodThrow () throws Exception{
        try{
            System.out.println(1/0);
        } catch (Exception e){
            throw e;
        }

    }

    public static void main (String[] args){
        _8_Exceptions exceptions = new _8_Exceptions();
        exceptions.testException();

        try {
            exceptions.exceptionMethodThrow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
