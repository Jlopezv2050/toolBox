package basis;

import java.awt.*;

/**
 * Created by juan on 21/11/16.
 * Java is pass-by-value.
   (OK, once again... with feeling.)
   Java is pass-by-value.
   For primitives, you pass a copy of the actual value.
   For references to objects, you pass a copy of the reference (the remote control).
 */
public class _5_Wrappers {

    private class swapPoint {
        Point firstPoint;

        swapPoint(Point notSwapablePoint){
            this.firstPoint = notSwapablePoint;
        }
    }

        public static void swapWrong(Point arg1, Point arg2)
        {
            //arg 1 is a copy from reference of pnt1 so it's pointing to pnt1 and will change it
            arg1.x = 100;
            arg1.y = 100;

            //temp will point to the same point that arg1 (pnt1) *
            Point temp = arg1;

            //arg 1 point to the same point that arg2 (pnt2) *
            arg1 = arg2;

            //arg2 point to the same point that temp (pnt1) *
            arg2 = temp;

            //arg 2 is pointing to pnt1
            arg2.x=89;
            arg2.y=76;
            // * point to the same point NOT point to the reference of the operand
        }

    public void swapWithWrapper (swapPoint a, swapPoint b){
        Point temp = a.firstPoint;
        a.firstPoint = b.firstPoint;
        b.firstPoint = temp;
    }

        public static void main(String [] args)
        {

            Point pnt1 = new Point(1,2);
            Point pnt2 = new Point(0,0);
            System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
            System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
            System.out.println(" ");
            swapWrong(pnt1, pnt2);
            System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
            System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);

            //Solutions
              //1. do directly at main method without use a method
              //2. use wrappers
            _5_Wrappers aux = new _5_Wrappers();

            swapPoint point1Custom = aux.new swapPoint(pnt1);
            swapPoint point2Custom = aux.new swapPoint(pnt2);
            aux.swapWithWrapper(point1Custom, point2Custom);

            System.out.println("X: " + point1Custom.firstPoint.x + " Y:" + point1Custom.firstPoint.y);
            System.out.println("X: " + point2Custom.firstPoint.x + " Y: " + point2Custom.firstPoint.y);



        }
    }



