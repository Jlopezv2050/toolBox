package basis;

/**
 * 1. Non-static Nested Classes:
 *  A. Inner classes
 *  B. Method local Inner classes
 *  C. Anonymous Inner classes
 *      C1. Class type
 *      C2. Interface / abstract implementer
 *      C3. In Method arguments
 *
 * 2. Static Nested classes
*/

public class _1b_InnerClasses {

    /*1A. Inner classes*/
    private class PrivateInnerClass{
        private int numer = 3;

        void printNumer(){
            System.out.println(this.numer);
        }
    }

    /*1B. Method local Inner classes*/
    void innerMethod() {
        class MethodInner_Demo {
            void print(){
                System.out.println("Printing method inner demo!!!");
            }
        }
        MethodInner_Demo methodInner_demo = new MethodInner_Demo();
        methodInner_demo.print();
    }

    /*1C2*/
    interface Ivolador{
        void fly();
        void cry();
    }

    /*1C3*/
    class Manager {
        public void canManage(Ivolador volador)
        {
            volador.fly();
            volador.cry();
        }
    }

    /*2 Static inner class*/
    private static class PrivateStaticInnerClass{
        private int numer = 3;

        void printNumer(){
            System.out.println(this.numer);
        }
    }

    public static void main(String[] args) {

        /*1A*/
        _1b_InnerClasses innerClasses = new _1b_InnerClasses();
        PrivateInnerClass privateInnerClass = innerClasses.new PrivateInnerClass(){

            //How to avoid this behaviour? declaring the number final
            void printNumer(){
                System.out.println("hacked!");
            }
        };
        privateInnerClass.printNumer();

        /*1B*/
        innerClasses.innerMethod();

        /*1C1*/
        PrivateInnerClass anonymousInnerclasses = innerClasses.new PrivateInnerClass(){
            void printNumer(){
                System.out.println("anonymousInnerClasses!");
            }
        };
        anonymousInnerclasses.printNumer();

        /*1C2*/
        Ivolador loro = new Ivolador() {
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

        /*1C3*/
        Manager manager = innerClasses.new Manager();
        manager.canManage(new Ivolador() {
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
        privateStaticInnerClass.printNumer();
    }
}
