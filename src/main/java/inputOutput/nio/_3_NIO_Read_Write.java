package inputOutput.nio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/**
 *
 * CHANNEL --> dataSource you're reading from or writing to (file, socket,...)
 * BUFFER --> container for the block of data. Typed only hold one type of data. Can specify size.
 * SELECTORS --> allow a single thread to manage the I/O for multiple channels
 *
 * Except FileChannel, in NIO we use 1 channel instance to read/write.
 *
 * */
public class _3_NIO_Read_Write{

    public static void main(String[] args) {

        /**
         * READ & WRITE FILE TEXT (UNCOMMENT TO RUN AND COMENT WRITE BINARY FILE)
         *
         * */
//            FileInputStream file = new FileInputStream("data.txt");
//            FileChannel channel = file.getChannel();

//        Path dataPath = FileSystems.getDefault().getPath("data.txt");
//        try {
//            Files.write(dataPath, "\nLine 5".getBytes("UTF-8"), StandardOpenOption.APPEND);
//            List<String> lines = null;
//            lines = Files.readAllLines(dataPath);
//            for(String line : lines) {
//                System.out.println(line);
//            }
//
//        } catch (IOException e) {
//            System.out.println(e);
//        }

        /**
         * READ & WRITE BINARY FILE
         *
         * */
        try(FileOutputStream binFile = new FileOutputStream("data.dat");
            FileChannel binChannel = binFile.getChannel()) {

            //WRITTING ARRAYS (YOU CAN USE THE INTS WAY)
            byte[] outputBytes = "Hello World!".getBytes();
            byte[] aux = outputBytes.clone();
            //Modifications to the buffer will change the array and change the array buffer
            //You are saying that outputBytes is the buffer with its length
            //Wrap reset the position to zero
            ByteBuffer buffer = ByteBuffer.wrap(outputBytes);
            //buffer.put("asd".getBytes());
            int numBytes = binChannel.write(buffer);
            System.out.println(outputBytes == aux);
            System.out.println("numBytes written was: " + numBytes);

            //WRITTING INTS (YOU CAN USE THE ARRAYS WAY)
            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            //PutIn changes the buffer's position
            intBuffer.putInt(245);
            //We have to reset to zero

            //after allocate, FLIP!
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);

            intBuffer.flip();
            intBuffer.putInt(-98765);
            //You can say the index to write, in this case is overwriting the -98765
            //intBuffer.putInt(0,245);
            intBuffer.flip();
            numBytes = binChannel.write(intBuffer);
            System.out.println("numBytes written was: " + numBytes);


            //READ WITH JAVA IO
//            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
//            byte[] b = new byte[outputBytes.length];
//            ra.read(b);
//            System.out.println(new String(b));
//
//            long int1 = ra.readInt();
//            long int2 = ra.readInt();
//            System.out.println(int1);
//            System.out.println(int2);



            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            //to demonstrate the wrap/output array relation
            outputBytes[0] = 'a';
            outputBytes[1] = 'b';
            buffer.flip();
            long numBytesRead = channel.read(buffer);
            if (buffer.hasArray()) {
                System.out.println("byte buffer = " + new String(buffer.array()));
                //to demonstrate the wrap/output relation
//                System.out.println("byte buffer = " + new String(outputBytes));
            }

            // Absolute read (cursor is not moved)
            intBuffer.flip();
            ByteBuffer intBuffer2 = ByteBuffer.allocate(Integer.BYTES*2);

            numBytesRead = channel.read(intBuffer2);
            System.out.println(intBuffer2.getInt(0));
            System.out.println(intBuffer2.getInt(4));


            System.out.println(intBuffer.getInt());


//             //Relative read (cursor is moved) (UNCOMMENT TO RUN AND COMMENT ABSOLUTE READ)
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());
//            intBuffer.flip();
//            numBytesRead = channel.read(intBuffer);
//            intBuffer.flip();
//            System.out.println(intBuffer.getInt());

            channel.close();
            ra.close();

            System.out.println("outputBytes = " + new String(outputBytes));


        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}