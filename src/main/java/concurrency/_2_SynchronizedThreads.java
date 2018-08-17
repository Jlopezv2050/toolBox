package concurrency;

/**
 * Java provide how to access to the variable memory (heap) to
 * maintain the integrity (synchronization)
 *
 * EXCEPTION -- using string variable (the reason, is string objects
 * are reused within the jvm (jvm use a string pools for allocation of string objects ))
 */
public class _2_SynchronizedThreads {

    private class thread1 implements Runnable{
        @Override
        public void run() {
            doCountDown();
        }
    }

    private synchronized void doCountDown() {
        int sharedVariable;
        for (sharedVariable = 10 ; sharedVariable > 0; sharedVariable--){
            if (Thread.currentThread().getName().equals("Thread1")){
                System.out.println(_1_Threads.ANSI_GREEN + "Thread 1, value: "+ sharedVariable);
            } else if (Thread.currentThread().getName().equals("Thread2")){
                System.out.println(_1_Threads.ANSI_PURPLE + "Thread 2, value: "+ sharedVariable);
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
        _2_SynchronizedThreads a2SynchronizedThreads = new _2_SynchronizedThreads();

        Thread thread1 = new Thread(a2SynchronizedThreads.new thread1());
        Thread thread2 = new Thread(a2SynchronizedThreads.new thread2());

        thread1.setName("Thread1");
        thread2.setName("Thread2");
        thread1.start();
        thread2.start();
    }
}
