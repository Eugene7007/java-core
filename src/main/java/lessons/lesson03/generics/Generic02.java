package lessons.lesson03.generics;

public class Generic02 {

    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.println(element);
        }
    }
}
