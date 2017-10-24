package javaConcurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Reentrancy -> you do something, and while you are still doing it, you do it again:
 *
 *          synchronized (objLock) {
 *              doSomething(lock, ...)
 *          }
 *          public void doSomething(Object lock, ...) {
 *              synchronized (lock) {
 *              }
 *          }
 *
 * STATES TO UNDERSTAND DIFFERENCES BETWEEN SYNCHRONIZE AND LOCK
 * --------------------------------------------------------------------------------------------
 * WAITING -> thread calls wait()
 * BLOCKED -> thread is notified but has not object lock yet
 *
 * Synchronize code DRAWBACKS
 *---------------------------------------------------------------------------------------------
 * 1. Threads can be suspended/blocked while executing a single line:
 *    double a = 2.0; long b = 2L;
 *    ATOMIC obj1.equals(obj2) and read/write primitive except long/double
 *
 * 2. thread are blocked wait to execute sync can't be interrupted. Wait until obtain the intrinsic lock.
 *    SOL -> use Lock
 *
 * 3. We can't test if an object intrinsic lock is available
 *    SOL -> Lock has tryLock() and tryLock(time)
 *
 * 4. The sync block must be within the same method. we can't start a sync block in one method and end in another
 *    SOL -> Call Lock() in one method and unLock() in other method.
 *
 * 5. If multiple threads are waiting to get a lock it's not first come first served
 *    SOL -> ReentrantLock(true) FIFO
 */
//https://stackoverflow.com/questions/18356795/static-versus-non-static-lock-object-in-synchronized-block


import static javaConcurrent._6_ReentrantLock.EOF;

public class _6_ReentrantLock {
    public static final String EOF = "EOF";

    public static void main(String[] args) {
        List<String> buffer = new ArrayList<String>();
        ReentrantLock bufferLock = new ReentrantLock();
        MyProducerLock producerLock = new MyProducerLock(buffer, ThreadColors.ANSI_BLUE, bufferLock);
        MyConsumerLock consumerLock1 = new MyConsumerLock(buffer, ThreadColors.ANSI_PURPLE, bufferLock);
        MyConsumerLock consumerLock2 = new MyConsumerLock(buffer, ThreadColors.ANSI_CYAN, bufferLock);

        new Thread(producerLock).start();
        new Thread(consumerLock1).start();
        new Thread(consumerLock2).start();
    }
}

class MyProducerLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyProducerLock(List<String> buffer, String color, ReentrantLock bufferLock) {
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
                bufferLock.lock();
                buffer.add(num);
                bufferLock.unlock();

                Thread.sleep(random.nextInt(1000));
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}

class MyConsumerLock implements Runnable {
    private List<String> buffer;
    private String color;
    private ReentrantLock bufferLock;

    public MyConsumerLock(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    public void run() {
        while(true) {
            bufferLock.lock();
            if(buffer.isEmpty()) {
                bufferLock.unlock();
                continue;
            }
            if(buffer.get(0).equals(EOF)) {
                System.out.println(color + "Exiting");
                bufferLock.unlock();
                break;
            } else {
                System.out.println(color + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock();
        }
    }
}

