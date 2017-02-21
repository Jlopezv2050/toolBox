package javaCore;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by juan on 21/11/16.
 */
public class _6_Date_Time  {

    protected void printCurrentDate(){
        Date currentDate = new Date();
        System.out.println(currentDate);
    }

    static Date compareDateGettingTime(Date date1, Date date2){

        return date1.getTime() > date2.getTime() ? date1 : date2 ;
    }

    static boolean after_before(Date date1, Date date2, String operation){

        boolean result = false;

        switch (operation){
            case "AFTER":
                result = date1.after(date2);
                break;

            case "BEFORE":
                result = date1.before(date2);
                break;
        }
        return result;
    }

    static boolean equals(Date date1, Date date2){

        return date1.equals(date2);
    }

    static int compareToDate(Date date1, Date date2){

        return date1.compareTo(date2);
    }

    static void printSimpleDateFormat(Date date){

        SimpleDateFormat ft = new SimpleDateFormat ("E yyyy.MM.dd 'at' hh:mm:ss a zzz");

        try{
            if (date!=null){
                System.out.println("Current Date: " + ft.format(date));
            }

        } catch (NullPointerException np){
            System.out.println("NULLPERROR");
        }

    }

    //CALENDARS
    protected String calendaricos (){
        Calendar cal = new GregorianCalendar(2009, Calendar.MARCH, 6);
        //Add 4months and 5days
        cal.add(Calendar.MONTH, 4);
        cal.add(Calendar.DAY_OF_MONTH, 5);

        //Format
        SimpleDateFormat sdf = new SimpleDateFormat("d MMM yyyy");
        String dateFormated = sdf.format(cal.getTime());

        //Compare calendar is after (happened before) than current time
        if (cal.compareTo(Calendar.getInstance())==-1){

        }

        return dateFormated;
    }


}
