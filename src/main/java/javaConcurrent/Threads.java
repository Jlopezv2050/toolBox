package javaConcurrent;

/**
 * Threads are really operatting system dependent.
 * Anonymous class thread.
 */
public class Threads {
    //coloring technique
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";

    private class myThreadRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("MyThreadRunnable Run()");
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args){

        /**RUNNABLE VS SUBCLASSING
         * Why should we use runnable vs subclassing? more flexible and many methods in Java API for runnable.
         */
        new Thread() {
            public void run() {
                System.out.println(ANSI_BLUE +"Hello from the anonymous class thread");
            }
        }.start();

        Threads myThreadRunnable = new Threads();


        Thread myTh = new Thread(myThreadRunnable.new myThreadRunnable() {
            @Override
            public void run() {
                System.out.println("Annonymous Runnable class");
            }
        });

        /**SETTINGS*/

        myTh.setName("Annonymous Runnable class");
        myTh.setPriority(Thread.MAX_PRIORITY);

        //implement RUN but NOT CALL IT! CALL start!!!!!!!!!!!! if not it will be executed on main thread.
        myTh.start();

        /**SLEEPING*/
        //is never guaranteed the thread will sleep for x seconds
        //ex. SO not support nano granularity
        //other thread is interrupted
        try {
            Thread.sleep(3000,200);
        } catch (InterruptedException inEx){
            System.out.println("Another thread woke me up" + inEx.getStackTrace());
        }

        Thread anotherThread = new Thread(new AnotherThread());
        anotherThread.start();
        //only provoke an exception, take care returning from catch of anotherThread

        anotherThread.interrupt();

        System.out.println("He've reach after anotherThread");

        new Thread() {
            public void run() {
                try {
                    //if anotherThread is finished continue as if join wouldn't exist
                    anotherThread.join();
                    System.out.println(ANSI_CYAN +"another finished");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

        //getCurrentThread
        Thread.currentThread().getName();

        /**SHARED VARIABLES*/
        //race condition
        //interfering problems
    }
}

