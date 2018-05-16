package basis;

/**
 *
 * Is a name or identifier to associate allocated space of memory where we store
 * some information in RAM.
 *
 * An statement is a complete unit of execution.
 * Statement --> variable = literal (any number, text, or other info representing a value)
 * Statements -->
 *              a. Assigment expression --> int score = 100; (expression score = 100)
 *              b. Use of ++ or --  --> aValue++;   (expression aValue++ without ;)
 *              c. Method invocation statement --> System.out.println("You got high score!"); (expression "You got high score!")
 *              d. object creation statement  Bicycle myBike = new Bicycle();
 *
 * Expressions --> a = b + 1
 *
 * A code block in Java is a chunk of code that's surrounded by a matched pair of curly braces: { }

 *
 * Local variable --> defined inside methods, need to be initialized before use it and destroyed when method is finished.
 * Instance/member variable --> within a class but outside any method. Initialized when the class is instantiated by default.
 * Class variable --> instance variable with static keyword
 *
 * Access control Modifiers --> private, public, protected
 * Non-Access Modifiers --> static, final, abstract, synchronized
 *

 *    byte : 8-bits. -128 y 127.
 *    short : 16-bits. -32768 y 32767.
 *    int : 32-bits. -2147483648 y 2147483647.
 *    long : 64-bits. -9_223_372_036_854_775_808L y 9_223_372_036_854_775_807L.
 *
 *    float :  32-bits.
 *    double : 64-bits.
 *
 *    char : 16-bits. Unicode.  '\u0000' / '\uffff' ( 0 a 65535 )
 *    boolean : true /false.
 *
 *    A method can have a variable with the same name than a class and win except using keyword this.
 *
 *    In general, a set of curly brackets { } defines a scope.
 *    Scope class, method, loop. Visibility depends on public, private, default, package.
 *    Visibility refers to if you can use a variable from a given place in the program.
 */
public class _2_Variables {

    private String sameNameThanMethod;

    //Class and instance variables are automatically initialized to their default values

    //class/static variable
      //stored in the static memory
      //values can be assigned during the declaration or within the constructor
      //non-modifiable constant
      //constants in upper case
      //field by class not one by instance (class variable) but one of each class

    private static final double POUND_PER_KILOGRAM = 0.45_359_237d;
    static int daily_currency_Value = 13;

    //instance variables
      //slot for each variable  when an object is allocated in the heap
      //recommended to make private
      //have default values (it'd be necessary to inform)

    private byte byteVariable1 = 10; //byte
    //java considers integer or long by default any whole number variable
    //need cast with expressions assigned to short/byte
    private byte byteVariable = (byte)(byteVariable1/2);
    private int intVariable   = 20;   //int
    private long longVariable = 0L;  //long
    private int intDivision   = 5/2; //2

    private float  floatVariable  = (float) 0.0; //single precision 0.0000000 (7)

    //if you don't cast or indicate f, it assume the variable is a double by default
    private float  floatVariable2  = 0.0f;
    private float  floatVariableNoFloat  = 0f;
    //use because
      //faster in modern computers
      //used in-built functions (ej. sin)
      //far more precise
    private double doubleVariable = 0.0D; //double precision 0.0000000000000000 (16)

    //char
      //only can contain one character
    private char charVariable ='\u2620';

    //boolean
    private boolean booleanVariable ;

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
}