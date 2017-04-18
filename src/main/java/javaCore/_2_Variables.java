package javaCore;

/**
 * Created by juan on 21/11/16.
 *
 * Local variable --> defined inside methods, destroyed when method is finished.
 * Instance variable --> within a class but outside any method. Initialized when the class is instantiated.
 * Class variable --> instance variable with static keyword
 *
 * Access control Modifiers --> private, public, protected
 * Non-Access Modifiers --> static, final, abstract, synchronized
 *
 *    boolean : true /false.
 *    byte : 8-bits. -128 y 127.
 *    short : 16-bits. -32768 y 32767.
 *    int : 32-bits. -2147483648 y 2147483647.
 *    long : 64-bits. -9223372036854775808 y 9223372036854775807.
 *    float :  32-bits.
 *    double : 64-bits.
 *    char : 16-bits. Unicode.  '\u0000' / '\uffff' ( 0 a 65535 )
 *
 */
public class _2_Variables {

    //instance variables
    //slot for each variable  when an object is allocated in the heap
    //recomended to make private
    //have default values (it'd be necessary to inform)
    private long   longVariable   = 0L;
    private int    intVariable    = 0;
    private double doubleVariable = 0.0d;
    private float  floatVariable  = 0.0f;
    private boolean booleanVariable = false;

    //class/static variables
    //field by class not one by instance (class variable) but one of each class
    static int daily_currency_Value = 13;

    //static variable
    //stored in the static memory
    //values can be assigned during the declaration or within the constructor
    //non-modifiable constant
    //constants in upper case
    public final static double GRAVITATIONAL_ACCELERATION = 9.80665d;


    //only visible in src.main.java package and its classes
    protected void printMaxPrimitivesValue (){

        System.out.println("Max value of long primitive is: " + Long.MAX_VALUE);
        System.out.println("Max value of int primitive is: " + Integer.MAX_VALUE);
        System.out.println("Max value of double primitive is: " + Double.MAX_VALUE);
        System.out.println("Max value of float primitive is: " + Float.MAX_VALUE);
    }

    static void printMinPrimitivesValue (){

        System.out.println("Max value of long primitive is: " + Long.MIN_VALUE);
        System.out.println("Max value of int primitive is: " + Integer.MIN_VALUE);
        System.out.println("Max value of double primitive is: " + Double.MIN_VALUE);
        System.out.println("Max value of float primitive is: " + Float.MIN_VALUE);

    }

    protected  int sumaDosPrimitivas (int a, int b){
        //local variable
        //are created when the method is entered
        //can not use access-modifiers
        //there is no default value, should be declared and initialized before the first use
        int suma;

        //even the variable has not been initialized here it is
        suma = a + b;
        a++;
        b += suma;

        return suma;
    }



}
