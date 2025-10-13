package lessons.lesson03.generics;

public class GenericStarter {

    public static void main(String[] args) {
        Generic01<String> stringBox = new Generic01<>();
        stringBox.set("Hello");
        System.out.println(stringBox.get()); // Hello

        Generic01<Integer> intBox = new Generic01<>();
        intBox.set(42);
        System.out.println(intBox.get()); // 42

        ////////////////////////////////////
        String[] names = {"Alice", "Bob"};
        Integer[] numbers = {1, 2, 3};

        Generic02.printArray(names);
        Generic02.printArray(numbers);
        ////////////////////////////////////
        System.out.println(Generic03.square(5));     // int -> 25.0
        System.out.println(Generic03.square(3.14));  // double -> 9.8596
//         Generic03.square("abc"); // Ошибка, String не Number
    }
}
