package lessons.lesson06;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        throwException();
//        catchException();
//        showHierarchyOfCatches();
//        showCatchWithMultipleExceptions();
//        showFinallyBlockExceptions();
//        showTryWithResourcesExceptions();
    }


    private static void throwException() throws IOException {
        var file = new FileReader("test.txt");
        var buffer = new BufferedReader(file);
        var line = buffer.readLine();

        while (line != null) {
            System.out.println(line);
            line = buffer.readLine();
        }

        System.out.println("Buffer is active : " + buffer.read());
    }

    private static void catchException() {
        try {
            var file = new FileReader("test.txt");
            var buffer = new BufferedReader(file);
            var line = buffer.readLine();

            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showHierarchyOfCatches() {
        try {
            // some code
        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException");
        } catch (Exception e) {
            System.out.println("Exception");
        } catch (Throwable e) {
            System.out.println("Throwable");
        }
    }

    private static void showCatchWithMultipleExceptions() {
        try {
            throw new JavaException("Hello World");
        } catch (NullPointerException | ArithmeticException | JavaException e) {
            System.out.println("Exceptions : " + e.getMessage());
        }
    }

    private static void showFinallyBlockExceptions() throws IOException {
        BufferedReader buffer = null;

        try {
            var file = new FileReader("test.txt");
            buffer = new BufferedReader(file);
            var line = buffer.readLine();

            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (buffer != null) {
                    buffer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Buffer is active : " + buffer.read());
    }

    private static void showTryWithResourcesExceptions() {
        try (var buffer = new BufferedReader(new FileReader("test.txt"))) {
            var line = buffer.readLine();

            while (line != null) {
                System.out.println(line);
                line = buffer.readLine();
            }
        } catch (IOException e) {
            throw new JavaException("Hello World");
        }
    }
}
