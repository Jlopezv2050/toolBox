package javaCore;

/**
 * Created by juan on 24/11/16.
 */
public class _7_Methods_Constructors {

    //way to avoid else
    private static boolean reduceIfElse (int a){
        if (a==3) return true;
        return false;
    }

    int a = 0;

    public _7_Methods_Constructors() {
        System.out.println("Default Constructor");
    }

    public _7_Methods_Constructors(int a) {
        this();
        this.a = a;
        System.out.println("Customized Constructor");
    }

    /**
     * Enables you to pass a variable numbr of arguments of the same type to a method. Only one variable-length parameter
     * may be specified in a method and must be the last. Any regular parameters must precede it.
     *
     * @since JDK 1.5
     * @param numbers description
     * @see <a href="https://www.tutorialspoint.com/java/java_methods.htm">TutorialsPoint</a>
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
