package cores;

/**
 * Created by juan on 21/11/16.
 */
public class _4_Strings{

    protected static void printStringWithNumbersVariables() {
        String numberString = "245.43";
        numberString = numberString + "10.9";
        System.out.println(numberString);

        numberString = numberString + 50;
        System.out.println(numberString);
    }
    public static void main (String[] args){
        double doublevar = 20.0D;
        double doublevar2 = 80.0D;
        doublevar = 25*(doublevar +doublevar2);
        if ((doublevar%40)<=20) System.out.println("Total was over the limit"+ doublevar%40);

    }
}
