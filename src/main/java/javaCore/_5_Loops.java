package javaCore;

/**
 * Created by juan on 27/04/17.
 */
public class _5_Loops {

    static int ifElseVariable;
    static char switchVariable = '%';
    static String stringVariable = "Connection";

    private static int fastIfElseReturn (){

        if (ifElseVariable != 0){
            return -1;
        }
        return ifElseVariable;
    }

    public static void main (String[] args){
        //IF - ELSE
        // fast return
        System.out.println(fastIfElseReturn());

        //SWITCH
        //primitives
        //Multiple case in one statement
        switch (switchVariable){

            case 'A':
                System.out.println("The char is: "+switchVariable);
                break;

            case 'B':case'C':case'D':
                System.out.println("The char is: "+switchVariable);
                break;

            default:
                System.out.println("The char is not A, B, C or D.");
        }

        //String since JDK 1.7
        switch (stringVariable.toLowerCase()){
            case ("Connection"):
                //forget break

            default:
                System.out.println("No string founded..");
        }

    }




}
