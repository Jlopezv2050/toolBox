package concurrency;

public class _1_b_AnotherThread implements Runnable{
    @Override
    public void run() {
        try {
            Thread.sleep(3000,200);
        } catch (InterruptedException e) {
            System.out.println(_1_Threads.ANSI_GREEN + "Another Thread problem: "+ e.getMessage());
            //return to prevent continue with the run
            return;
        }
        System.out.println(_1_Threads.ANSI_BLACK + "I've reached after try/catch");
    }

}