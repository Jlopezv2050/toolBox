package concurrency;

/**
 * Threads are really operating system dependent.
 */
public class _1_Threads {
    //coloring technique
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private class myThreadRunnable implements Runnable {
        @Override
        public void run() {
            System.out.println(ANSI_RESET + "I'm runnable object an I'm being executed.");

        }
    }

    public static void main(String[] args){
//        RUNNABLE VS SUBCLASS
//        1. You're not specialising the thread's behaviour (Subclass (extends)).
//            You're just giving it something to run.
//        2. You can implement Runnable and be able to extend from another class as well.
//
//               public class MyThread extends Thread {
//                    public MyThread() {
//                        super("MyThread");
//                    }
//                    public void run() {
//                       //Code
//                    }
//               }
//               //Started with a "new MyThread().start()" call


        //Thread instance executing runnable class
        _1_Threads myThreadRunnable = new _1_Threads();
        Thread myTh = new Thread(myThreadRunnable.new myThreadRunnable());

        //SETTINGS
        myTh.setName("Anonymous Runnable class");
        myTh.setPriority(Thread.MAX_PRIORITY);

        //implement RUN but CALL start! otherwise it will be executed on main thread.
        myTh.start();

        //SLEEPING
        //is never guaranteed the thread will sleep for x seconds
        //ex. SO not support specified granularity (millis, nanos)
        //other thread is interrupted
        Thread anotherThread = new Thread(new _1_b_AnotherThread());
        anotherThread.setName("AnotherThread");
        anotherThread.start();

        anotherThread.interrupt();
        System.out.println(ANSI_RED + "I've reach after anotherThread");


        //ANONYMOUS CLASS (to risky (we haven't variable, interrupt,...)
        new Thread(null, null, "AnonymousThread") {
            public void run() {
                System.out.println(ANSI_BLUE +"Executing: " + Thread.currentThread().getName());
            }
        }.start();
        //DO INSTEAD
        Thread threadInsteadAnonymous = new Thread(null, null, "AnonymousThread") {
            public void run() {
                System.out.println(ANSI_BLUE +"Executing: " + Thread.currentThread().getName());
            }
        };
        threadInsteadAnonymous.start();

        //UP TO JV8
        // new Thread(){}.start();

        //LAMBDA
        new Thread(() -> {
            try {
                //Waits for this thread to die
                //(if anotherThread is finished continue as if join wouldn't exist)
                anotherThread.join();
                System.out.println(ANSI_CYAN +"Another finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}