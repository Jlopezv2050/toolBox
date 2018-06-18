package basis;

import java.io.FileReader;
import java.io.IOException;

public class _8_Exceptions {
    int a= 1;
    //CHECKED (can NOT prevent)
        //compile time
        //NO RuntimeException
        //caught or MUST thrown

        //FileNotFoundException
        //IOException
        //SocketException

    //UNCHECKED (CAN prevent)
        //RuntimeException
        //caught or MAY thrown

        //ArrayIndexOutOfBoundsException
        //NullPointerException
        //IlegalArgumentException

    //errors
      //stackOverflow
      //JVM out of memory

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
    protected void exceptionMethodThrow () throws _8_b_User_Defined_Exceptions{

        throw new _8_b_User_Defined_Exceptions("MESSAGE");

    }


    public static void main (String[] args){

        _8_Exceptions exceptions = new _8_Exceptions();
        exceptions.testException();
    }

}
