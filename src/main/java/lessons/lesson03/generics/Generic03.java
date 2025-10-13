package lessons.lesson03.generics;

public class Generic03 {

    public static <T extends Number> double square(T number) {
        return number.doubleValue() * number.doubleValue();
    }
}
