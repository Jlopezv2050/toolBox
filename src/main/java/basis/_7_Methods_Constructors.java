package basis;

/**
 * THIS VS SUPER (first statement, can use params)
 *    this --> in order to rehuse class constructor
 *    super --> in order to rehuse parents constructor
 */
public class _7_Methods_Constructors {

    int a = 0;

    public _7_Methods_Constructors() {
        System.out.println("Default Constructor");
    }

    public _7_Methods_Constructors(int a) {
        this();
        this.a = a;
        //you can use a final variable in constructor
        final int b = 1;
        System.out.println("Customized Constructor");
    }

    /**
     * Enables you to pass a variable numbr of arguments of the same type to a method. Only one variable-length parameter
     * may be specified in a method and must be the last. Any regular parameters must precede it.
     */
    protected static void printMax( double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument passed");
            return;
        }

        double result = numbers[0];

        for (int i = 1; i <  numbers.length; i++)
            if (numbers[i] >  result)
                result = numbers[i];
        System.out.println("The max value is " + result);
    }

    public static void main (String [] args){
        //System.out.println("main [] args --> "+args[0]);
        //_7_Methods_Constructors methods_constructors = new _7_Methods_Constructors(10);
        double arrayDoubles [] = {1.0,2.3};
        printMax(arrayDoubles);
    }
}

class ChainingConstructors extends _7_Methods_Constructors {

    private int c;
    private int d;

    public ChainingConstructors(int c, int d) {
        this(0,c,d);
    }
    public ChainingConstructors(int a, int c, int d) {
        super(a);
        this.c = c;
        this.d = d;
    }

}




