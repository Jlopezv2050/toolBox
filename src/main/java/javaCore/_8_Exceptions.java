package javaCore;

import java.io.FileReader;
import java.io.IOException;

/**
 * Created by juan on 24/11/16.
 */
public class _8_Exceptions {
    int a= 1;
    //checked
      //compile time
        //FileNotFoundException

    //unchecked
      //runtime
        //ArrayIndexOutOfBoundsException

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
