package javaConcurrent;


import java.util.Random;
import java.util.concurrent.*;

import static javaConcurrent._8_ExecutorServices.EOF;

/**
 * We create an implementation of EXECUTIVE SERVICE (java.util.concurrent.executors) and give it a runnable task
 * We don't directly manage thread life cycle only we focus on the thread code.
 *
 * FixedThreadPool --> reduces the overhead creation (especially with a lot of threads)
 *                     limit the number of threads
 *                     CALL executorService.shutdown()
 *
 * Future --> we want to receive a value back from a thread --> we submit method.
 *
 * ArrayBlockingQueue --> thread safe FIFO
 * */
public class _8_ExecutorServices {

public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<String>(6);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        MyProducerArrayBlockingQueue producer = new MyProducerArrayBlockingQueue(buffer, ThreadColors.ANSI_BLUE);
        MyConsumerArrayBlockingQueue consumer1 = new MyConsumerArrayBlockingQueue(buffer, ThreadColors.ANSI_PURPLE);
        MyConsumerArrayBlockingQueue consumer2 = new MyConsumerArrayBlockingQueue(buffer, ThreadColors.ANSI_CYAN);

        executorService.execute(producer);
        executorService.execute(consumer1);
        executorService.execute(consumer2);

        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println(ThreadColors.ANSI_RED + "I'm being printed for the Callable class");
                return "This is the callable result";
            }
        });

        try {
            System.out.println(future.get());
        } catch(ExecutionException e) {
            System.out.println("Something went wrong");
        } catch(InterruptedException e) {
            System.out.println("Thread running the task was interrupted");
        }

        executorService.shutdown();
    }
}

class MyProducerArrayBlockingQueue implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyProducerArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {
        Random random = new Random();
        String[] nums = { "1", "2", "3", "4", "5"};

        for(String num: nums) {
            try {
                System.out.println(color + "Adding..." + num);
                buffer.put(num);

                Thread.sleep(random.nextInt(1000));
                //thread can be interrupted while it's blocked (ex. waiting lock own)
            } catch(InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
        }

        System.out.println(color + "Adding EOF and exiting...");
        try {
            buffer.put("EOF");
        } catch(InterruptedException e) {
        }
    }
}

class MyConsumerArrayBlockingQueue implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String color;

    public MyConsumerArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    public void run() {

        while(true) {
            //WHY IF IS THREAD SAFE? If a consumer is blocked between isEmpty and peek while another
            //consumer take from a one element array when it will take it return nullPointerException
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    // check if there is an element
                    if (buffer.peek().equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        //take removing from the list
                        System.out.println(color + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}