package basis;

/**
 * <h1>Non-static Nested Classes</h1>
 * <ol>
 *     <li><b>Non-static Nested Classes</b>
 *          <ol type="A">
 *              <li>Inner classes</li>
 *              <li>Method local Inner classes</li>
 *              <li>Anonymous Inner classes with Class / Interface / abstract implementer</li>
 *              <li>Anonymous Inner classes In Method arguments</li>
 *          </ol>
 *     </li>
 * <li><b>Static Nested Classes</b></li>
 * </ol>
 * <p>
 * <b>Note:</b> Anonymous Inner classes (declared without class name).
 * <b>Note:</b> Inner class can see class variables.
 *
 * @author  jlopezv
 * @version 1.0
 * @since   2016
 *
 */

public class _1b_InnerClasses {

    /*1A. Inner classes*/
    private class PrivateInnerClass {
        private int number = 3;

        void printNumber() {
            System.out.println(this.number);
        }
    }

    /*1B. Method local Inner classes*/
    void innerMethod() {
        class MethodInner_Demo {
            void print() {
                System.out.println("Printing method inner demo!!!");
            }
        }
        MethodInner_Demo methodInner_demo = new MethodInner_Demo();
        methodInner_demo.print();
    }

    /*1C1*/
    interface ICanFly {
        void fly();

        void cry();
    }

    /*1C2*/
    class Manager {
        public void canManage(ICanFly flyObj) {
            flyObj.fly();
            flyObj.cry();
        }
    }

    /*2 Static inner class
    * An static class is "shared" by all the outher class (_1b_InnerClass) instances*/
    private static class PrivateStaticInnerClass {
        private int number = 3;

        void printNumber() {
            System.out.println(this.number);
        }
    }

    public static void main(String[] args) {

        _1b_InnerClasses innerClasses = new _1b_InnerClasses();

        /*1A*/
        PrivateInnerClass privateInnerClass = innerClasses.new PrivateInnerClass() {

            //How to avoid this behaviour? declaring the number final
            void printNumber() {
                System.out.println("hacked!");
            }
        };
        privateInnerClass.printNumber();

        /*1B*/
        innerClasses.innerMethod();

        /*1C1*/
        ICanFly loro = new ICanFly() {
            @Override
            public void fly() {
                System.out.println("Is flying");
            }

            @Override
            public void cry() {
                System.out.println("Is flying");
            }
        };
        loro.cry();
        loro.fly();

        /*1C2*/
        Manager manager = innerClasses.new Manager();
        manager.canManage(new ICanFly() {
            @Override
            public void fly() {
                System.out.println("Can manage will fly like this!");
            }

            @Override
            public void cry() {
                System.out.println("Can manage will cry like this!");
            }
        });

        /*2*/
        _1b_InnerClasses.PrivateStaticInnerClass privateStaticInnerClass = new _1b_InnerClasses.PrivateStaticInnerClass();
        privateStaticInnerClass.printNumber();
    }
}