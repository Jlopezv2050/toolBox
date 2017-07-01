package javaConcurrent;

/**
 * Java provide how to acces to the variable memory (heap) to
 * maintain the integrity (shyncronization)
 *
 * EXCEPTION -- using string variable (the reason, is string objects
 * are reused within the jvm (jvm use a string pools for allocation of string objects ))
 */
public class SynchronizedThreads {

    private int sharedVariable;

    private class thread1 implements Runnable{
        @Override
        public void run() {
            doCountDown();
        }
    }

    private synchronized void doCountDown() {
        for (sharedVariable = 10 ; sharedVariable > 0; sharedVariable--){
            if (Thread.currentThread().getName().equals("Thread1")){
                System.out.println(Threads.ANSI_GREEN + "Thread 1, value: "+ sharedVariable);
            } else if (Thread.currentThread().getName().equals("Thread2")){
                System.out.println(Threads.ANSI_PURPLE + "Thread 2, value: "+ sharedVariable);
            }
        }
    }

    private class thread2 implements Runnable{

        @Override
        public void run() {
            doCountDown();
        }
    }

    public static void main(String[] args) {
        SynchronizedThreads synchronizedThreads = new SynchronizedThreads();

        Thread thread1 = new Thread(synchronizedThreads.new thread1());
        Thread thread2 = new Thread(synchronizedThreads.new thread2());

        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();
    }
}
