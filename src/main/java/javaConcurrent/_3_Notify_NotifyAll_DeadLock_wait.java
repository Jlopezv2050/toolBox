package javaConcurrent;

import java.util.Random;

/**
 * 1. Without wait, writer starts setting empty = false and the next for iteration get deadLocked.
 * 2. Wait ->  Causes the current thread to wait until another thread invokes the {@link java.lang.Object#notify()}.
 * 3. NotifyAll -> All threads are waiting for this lock release.
 * while instead if in wait -> interrupts and spurious wake ups are possible
 * */
public class _3_Notify_NotifyAll_DeadLock_wait {

    public static void main(String[] args) {
        Message message = new Message();
        (new Thread(new Writer(message))).start();
        (new Thread(new Reader(message))).start();
    }
}

    class Message {
        private String message;
        private boolean empty = true;

        public synchronized String read() {
            while(empty) {
                try {
                    wait();
                //if any thread interrupted while the current thread was waiting for a notification
                } catch(InterruptedException e) {

                }

            }
            empty = true;
            notifyAll();
            return message;
        }

        public synchronized void write(String message) {
            while(!empty) {
                try {
                    wait();
                } catch(InterruptedException e) {

                }

            }
            empty = false;
            this.message = message;
            notifyAll();
        }
    }

    class Writer implements Runnable {
        private Message message;

        public Writer(Message message) {
            this.message = message;
        }

        public void run() {
            String messages[] = {
                    "Humpty Dumpty sat on a wall",
                    "Humpty Dumpty had a great fall",
                    "All the king's horses and all the king's men",
                    "Couldn't put Humpty together again"
            };

            Random random = new Random();

            for(int i=0; i<messages.length; i++) {
                message.write(messages[i]);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch(InterruptedException e) {

                }
            }
            message.write("Finished");
        }
    }

    class Reader implements Runnable {
        private Message message;

        public Reader(Message message) {
            this.message = message;
        }

        public void run() {
            Random random = new Random();
            for(String latestMessage = message.read(); !latestMessage.equals("Finished");
                latestMessage = message.read()) {
                System.out.println(latestMessage);
                try {
                    Thread.sleep(random.nextInt(2000));
                } catch(InterruptedException e) {

                }
            }
        }
    }

