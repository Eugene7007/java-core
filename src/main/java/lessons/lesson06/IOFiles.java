package lessons.lesson06;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOFiles {

    private static final int CHARACTER_END_OF_STREAM = -1;

    /*
        Reader
        Writer

        InputStream
        OutputStream
     */
    public static void main(String[] args) throws IOException {
//        showFileOutputStreamIO();
//        showBufferedWriterAndReaderIO();
//        showBufferedOutputAndInputStreamIO();

//        showFileIO();
        showFileWriterAndReaderIO();


    }

    private static void showFileIO() throws IOException {
        File file = new File("io_file_writer");
        file.createNewFile();

        var hasFile = file.exists();

        System.out.println(hasFile);

//        file.delete();
    }

    private static void showFileWriterAndReaderIO() throws IOException {
        String fileName = "io_file_writer";

        // write
        FileWriter fileWriter = new FileWriter(fileName);
        for (int i = 0; i < 10; i++) {
            fileWriter.write(i + "\n");
//            fileWriter.flush();
        }
        fileWriter.close();

        // read
        FileReader fileReader = new FileReader(fileName);

        int character;
        while ((character = fileReader.read()) != CHARACTER_END_OF_STREAM) {
//            System.out.print((char) character);
            System.out.print(character + " ");
        }
        fileReader.close();
    }

    private static void showBufferedWriterAndReaderIO() {
        String fileName = "io_file_writer";
        // write
        try (var bufferedWriter = new BufferedWriter(new FileWriter(fileName)) ){
            for (int i = 0; i < 10; i++) {
                bufferedWriter.write(i + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read
        try (var bufferedReader = new BufferedReader(new FileReader(fileName))){
            int character;

            while ((character = bufferedReader.read()) != CHARACTER_END_OF_STREAM) {
                System.out.print((char) character);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showBufferedOutputAndInputStreamIO() {
        String fileName = "io_file_output_stream";

        // write
        try (var bos = new BufferedOutputStream(new FileOutputStream(fileName))) {
            byte[] strToBytes = "Hello world".getBytes();
            bos.write(strToBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // read
        try (var bis = new BufferedInputStream(new FileInputStream(fileName))) {
            int byteData;
            while ((byteData = bis.read()) != CHARACTER_END_OF_STREAM) {
                System.out.print(byteData + " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
