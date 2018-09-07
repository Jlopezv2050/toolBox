package inputOutput.io;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * About exceptions, use tryWithResource (or multipleResource)
 */
public class _2_File_Reader_Writer_character_stream {
    private final static String FILE_NAME = "C:\\Temp\\input.txt";
    private final  static String OUTPUT_FILE_NAME = "C:\\Temp\\output.txt";
    private final static Charset ENCODING = StandardCharsets.UTF_8;

    public static void main(String... aArgs) throws IOException{
        _2_File_Reader_Writer_character_stream text = new _2_File_Reader_Writer_character_stream();

        //treat as a small file
        List<String> lines = text.readSmallTextFile(FILE_NAME);
        log(lines);
        lines.add("This is a line added in code.");
        text.writeSmallTextFile(lines, FILE_NAME);

        //treat as a large file - use some buffering
        text.readLargerTextFile(FILE_NAME);
        lines = Arrays.asList("Down to the Waterline", "Water of Love");
        text.writeLargerTextFile(OUTPUT_FILE_NAME, lines);

        //large file alternative
        readLargerTextFileAlternative();
        scannerFileReader();
    }

    //For small files
    /**
     Note: the javadoc of Files.readAllLines says it's intended for small
     files. But its implementation uses buffering, so it's likely good
     even for fairly large files.
     */
    private List<String> readSmallTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        return Files.readAllLines(path, ENCODING);
    }

    private void writeSmallTextFile(List<String> aLines, String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        Files.write(path, aLines, ENCODING);
    }

    //For large files
    private void readLargerTextFile(String aFileName) throws IOException {
        Path path = Paths.get(aFileName);
        try (Scanner scanner =  new Scanner(path, ENCODING.name())){
            while (scanner.hasNextLine()){
                //process each line in some way
                log(scanner.nextLine());
            }
        }
    }

    //AVOID DISK ACCESS BECAUSE INFO IS IN MEMORY
    private static void readLargerTextFileAlternative() throws IOException {
        Path path = Paths.get("filename.txt");
        try (BufferedReader reader = Files.newBufferedReader(path, ENCODING)){
            String line;
            while ((line = reader.readLine()) != null) {
                //process each line in some way
                log(line);
            }
        }
    }

    private void writeLargerTextFile(String aFileName, List<String> aLines) throws IOException {
        Path path = Paths.get(aFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
            for(String line : aLines){
                writer.write(line);
                writer.newLine();
            }
        }
    }

    private static void log(Object aMsg){
        System.out.println(String.valueOf(aMsg));
    }


    //Even is not necessary, you can use Scanner with FileReader
    private static void scannerFileReader(){
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileReader("asd.txt"));

            //scanner utils (we have split too)
            scanner.useDelimiter(";");
            scanner.skip(scanner.delimiter());

            System.out.println(scanner.hasNext());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) scanner.close();
            //We don't have to close FileReader because it implements Closeable and scanner.close has closed it.
        }
    }


}

