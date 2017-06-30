package javaConcurrent;


public class AnotherThread implements Runnable{

    @Override
    public void run() {
        try {
            Thread.sleep(13000);
        } catch (InterruptedException e) {
            System.out.println(Threads.ANSI_RED + e.getMessage() +". This thread has been interrupted");
            //return to prevent continue with the run
            return;
        }
        System.out.println(Threads.ANSI_RED + "He've reached after try/catch");
    }
}
