package concurrency;


import java.util.Random;
import java.util.concurrent.*;

import static concurrency._8_ExecutorServices.EOF;

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
 *
 * ArrayBlockingQueue vs LinkedBlockingQueue --> while ArrayBlockingQueue which is bounded, linkedBlockingQueue is optionally bounded.
 * Another difference between the two is how elements are stored
 * internally ArrayBlockingQueue uses array internally whereas LinkedBlockingQueue uses linked nodes.
 *
 * If you're just addint to the end of the list, an ArrayList is what you want.
 *
 * http://winterbe.com/posts/2015/04/07/java8-concurrency-tutorial-thread-executor-examples/
 * https://looksok.wordpress.com/2015/12/19/asynchronous-producer-consumer-with-blockingqueue-in-java/
 *
 * */
public class _8_ExecutorServices {

public static final String EOF = "EOF";

    public static void main(String[] args) {
        ArrayBlockingQueue<String> buffer = new ArrayBlockingQueue<>(3);

        ExecutorService executorService = Executors.newFixedThreadPool(5);


        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;


        MyProducerArrayBlockingQueue producer = new MyProducerArrayBlockingQueue(buffer, ThreadColors.ANSI_BLUE);
        MyConsumerArrayBlockingQueue consumer1 = new MyConsumerArrayBlockingQueue(buffer, ThreadColors.ANSI_PURPLE);
        MyConsumerArrayBlockingQueue consumer2 = new MyConsumerArrayBlockingQueue(buffer, ThreadColors.ANSI_CYAN);

//        executorService.execute(producer);
//        executorService.execute(consumer1);
//        executorService.execute(consumer2);

        boolean aux = true;
        boolean colorBlue = true;
        int i = 0;
        while(aux){

            executorService.execute(new MyConsumerTest(i, threadPoolExecutor.getActiveCount(), (i%2==0) ? 5000:10000, colorBlue ? ThreadColors.ANSI_BLUE: ThreadColors.ANSI_RED));

            colorBlue= !colorBlue;

            i++;
            if(i==100) aux = false;
        }

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
        String[] nums = { "1", "2", "3", "4", "5", "6", "7"};

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

class  MyConsumerTest implements Runnable {

    int threadNum;
    int activeThreads;
    int timeExecutions;
    String color;

    public MyConsumerTest(int threadNum, int activeThreads, int timeExecution, String color){
        this.threadNum = threadNum;
        this.activeThreads = activeThreads;
        this.timeExecutions = timeExecution;
        this.color = color;
    }

    @Override
    public void run() {
        System.out.println(color +"done!"+threadNum +"activeThreads: "+activeThreads +"time"+timeExecutions);
        try {
            Thread.sleep(timeExecutions);
        } catch (InterruptedException e) {

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
                        Thread.sleep(5000);
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        //take removing from the list
                        System.out.println(color + "Removed " + buffer.take());
                        Thread.sleep(5000);
                    }
                } catch (InterruptedException e) {

                }
            }
        }
    }
}