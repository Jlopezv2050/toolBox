package javaConcurrent;


/**
 * //imaginemos que tenemos dos threads que su run hacen un println de decremento pero sin compartir la clase countdown,
 //también habrían suspensiones, quiere decir esto que es la gestion del so que va suspendiendo o es en sí la función print

 //en caso de que haciendolo sin countdown no se interfieran
 //preguntar a bulchaka



 //two ways to notice he has been interrupted
 //1. catch the interrupted exception
 //2. https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html


 * Thread 1, value: 10
 Thread 1, value: 9
 Thread 1, value: 8
 Thread 1, value: 7
 Thread 1, value: 6
 Thread 2, value: 10
 Thread 1, value: 5
 Thread 2, value: 4
 Thread 2, value: 2
 Thread 2, value: 1
 Thread 1, value: 3*/
public class _3_InterruptionThreads {

    private int sharedVariable;

    private class thread1 implements Runnable{

        @Override
        public void run() {
            for (sharedVariable = 10 ; sharedVariable > 0; sharedVariable--){
                System.out.println(_1_Threads.ANSI_GREEN + "Thread 1, value: "+ sharedVariable);
            }
        }
    }

    private class thread2 implements Runnable{

        @Override
        public void  run() {
            for (sharedVariable = 10 ; sharedVariable > 0; sharedVariable--){
                System.out.println(_1_Threads.ANSI_PURPLE + "Thread 2, value: "+ sharedVariable);
            }
        }
    }

    public static void main(String[] args) {
        _3_InterruptionThreads _3_InterruptionThreads = new _3_InterruptionThreads();

        Thread thread1 = new Thread(_3_InterruptionThreads.new thread1());
        Thread thread2 = new Thread(_3_InterruptionThreads.new thread2());

        thread1.start();
        thread2.start();
    }
}
