package javaCore;

/**
 * Created by juan on 21/11/16.
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
 */
public class _2_Variables {

    //default values
    long   longVariable   = 0L;
    int    intVariable    = 0;
    double doubleVariable = 0.0d;
    float  floatVariable  = 0.0f;

    //field by class not one by instance
    static int daily_currency_Value = 13;

    //non-modifiable constant
    public final static double GRAVITATIONAL_ACCELERATION = 9.80665d;


    {
        System.out.println("non-static");
        PrimitivesStuff primitivesStuff = new PrimitivesStuff();
        primitivesStuff.workPrims(longVariable, intVariable, doubleVariable, floatVariable);
    }

    static {
        System.out.println("static");
        //printMinPrimitivesValue();
    }

    {
        System.out.println("non-static");
        //PrimitivesStuff primitivesStuff = new PrimitivesStuff();
        //primitivesStuff.workPrims(longVariable, intVariable, doubleVariable, floatVariable);
    }


    //only visible in _1_Variables class
    private class PrimitivesStuff{

        private void workPrims (long a, int b, double c, float d){

            System.out.println(a);
            System.out.println(b);
            System.out.println(c);
            System.out.println(d);
        }
    }


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
        int suma = 0;

        suma = a + b;
        a++;
        b += suma;

        return suma;
    }

}
