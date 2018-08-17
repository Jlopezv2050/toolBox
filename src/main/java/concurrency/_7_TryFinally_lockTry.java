package concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Use try/finally:
 *    1.Call unlock in one place
 *    2.Even the code within the lock cause an exception, unlock will be executed.
 *
 * Plain lock() isn't better than synchronized. The advantages come with:
 *    1. trylock() -- thread is not blocked if can't adquire the lock
 *    2. trylock(time)
 *    3. Fairness parameter -- turning into FIFO thread behaviour
 */
import static concurrency._7_TryFinally_lockTry.EOF;

public class _7_TryFinally_lockTry {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyTryFinallyProducer producer = new MyTryFinallyProducer(buffer, ThreadColors.ANSI_BLUE, bufferLock);
        MyTryFinallyConsumer consumer1 = new MyTryFinallyConsumer(buffer, ThreadColors.ANSI_PURPLE, bufferLock);
        MyTryFinallyConsumer consumer2 = new MyTryFinallyConsumer(buffer, ThreadColors.ANSI_CYAN, bufferLock);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}

class MyTryFinallyProducer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyTryFinallyProducer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                //lock() it's outside of the try because we shouldn't worried about the lock release until we actually
                //own it and if an exception occurred we will have an illegal state monitor releasing a lock not owned
                bufferLock.lock();
                try {
                    buffer.add(num);
                } finally {
                    bufferLock.unlock();
                }

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        try {
            buffer.add("EOF");
        } finally {
            bufferLock.unlock();
        }
    }
}

class MyTryFinallyConsumer implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyTryFinallyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {

        int counter = 0;

        while(true) {
            //We can check using queued length how many threads are waiting for the lock
            if(bufferLock.tryLock()) {
                try {
                    if(buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter = "+ counter);
                    counter = 0;

                    if(buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        System.out.println(color + "Removed " + buffer.remove(0));
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}
