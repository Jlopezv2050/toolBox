package inputOutput.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Used to transfer data between threads. Pipes has two channels:
 *  sink channel (multiple threads can write)
 *  source channel (multiple can read)
 *
 * */
public class _6_NIO_Pipes {

    public static void main(String[] args) {

        try {
            Pipe pipe = Pipe.open();

            Runnable writer = new Runnable() {
                @Override
                public void run() {
                    try {
                        Pipe.SinkChannel sinkChannel = pipe.sink();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++) {
                            String currentTime = "The time is: " + System.currentTimeMillis();

                            buffer.put(currentTime.getBytes());
                            buffer.flip();

                            while(buffer.hasRemaining()) {
                                sinkChannel.write(buffer);
                            }
                            buffer.flip();
                            Thread.sleep(100);

                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                }
            };


            Runnable reader = new Runnable() {
                @Override
                public void run() {

                    try {
                        Pipe.SourceChannel sourceChannel = pipe.source();
                        ByteBuffer buffer = ByteBuffer.allocate(56);

                        for(int i=0; i<10; i++) {
                            int bytesRead = sourceChannel.read(buffer);
                            byte[] timeString = new byte[bytesRead];
                            buffer.flip();
                            buffer.get(timeString);
                            System.out.println("Reader Thread: " + new String(timeString));
                            buffer.flip();
                            Thread.sleep(100);
                        }

                    } catch(Exception e) {
                        e.printStackTrace();
                    }

                }
            };

            new Thread(writer).start();
            new Thread(reader).start();

        } catch(IOException e) {
            e.printStackTrace();
        }


    }
}