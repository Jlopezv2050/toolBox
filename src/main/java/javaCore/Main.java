package javaCore;

import java.io.IOException;

/**
 * <h1>Main Class to instantiate All!</h1>
 * The AddNum program implements an application that
 * simply adds two given integer numbers and Prints
 * the output on the screen.
 * <p>
 * <b>Note:</b> Giving proper comments in your program makes it more
 * user friendly and it is assumed as a high quality code.
 *
 * @author  jlopezv
 * @version 1.0
 * @since   2016-11-21
 */
public class Main {

    public static void main (String [] args){

        _1_Classes   classes   = new _1_Classes();
        _2_Variables variables = new _2_Variables();
        _3_Arrays    arrays    = new _3_Arrays();
        _4_Strings   strings   = new _4_Strings();
        _5_Wrappers  wrappers  = new _5_Wrappers();
        _6_Date_Time date_time = new _6_Date_Time();
        _10_Files    files     = new _10_Files();



        /********************************************CLASSES***********************************************************/

        _1_Classes.Inner_1_Classes clas = classes.new Inner_1_Classes();
        System.out.println(clas.isGreatherThanZero(19));
        System.out.println("asdfa");


        /**************************************************************************************************************/



        /********************************************VARIABLES*********************************************************/
//        variables.printMaxPrimitivesValue();
//        int a = 5;
//        int result = variables.sumaDosPrimitivas(a,4);
//
//        System.out.println("RESULTADO: "+result);
//        System.out.println("VARIABLE A: " + a);
//
//
//        System.out.println(2 << 3);



        /**************************************************************************************************************/

        System.out.println(12|3);
        System.out.println('\u2665');



        /***********************************************ARRAYS*********************************************************/

        /**************************************************************************************************************/




        /*********************************************STRINGS**********************************************************/

        /**************************************************************************************************************/






        /*********************************************WRAPPERS*********************************************************/

        /**************************************************************************************************************/





        /**********************************************DATE_TIME*******************************************************/
        //_6_Date_Time.printSimpleDateFormat(null);
        /**************************************************************************************************************/

        /*********************************************INPUT_OUTPUT*****************************************************/

        /**************************************************************************************************************/




        /**********************************************EXCEPTIONS******************************************************/
        _8_Exceptions exceptions = new _8_Exceptions();
        exceptions.testException();
        /**************************************************************************************************************/

//        _1_Classes classes = new _1_Classes();
//        _2_Variables variablesClass = new _2_Variables();
//        _6_Date_Time date_time = new _6_Date_Time();
//
//        //variablesClass.printMaxPrimitivesValue();
//       // date_time.printCurrentDate();
//        Date date1 = new Date();
//        Date date2 = new Date();
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(date2);
//        cal.add(Calendar.DATE, 1);
//        date2 = cal.getTime();


//        Date result = new Date();
//        result = _6_Date_Time.compareDateGettingTime(date1, date2);
//
////        Double fl = _2_Variables.PI;
//        _2_Variables.printMinPrimitivesValue();
//
//        System.out.println(result);

    }
}
