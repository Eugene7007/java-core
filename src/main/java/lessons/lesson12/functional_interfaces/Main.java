package lessons.lesson12.functional_interfaces;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;
import static java.util.Comparator.reverseOrder;

public class Main {

    public static void main(String[] args) {
        Consumer<String> c1 = (name) -> System.out.printf("Hello %s", name);
        Consumer<String> c2 = (name) -> System.out.printf(", your name contains %d letters", name.length());
        Consumer<String> pipe = c1.andThen(c2);

//        c1.accept("Mary");
//        System.out.println("\n");
        pipe.accept("John");
        System.out.println("\n");

        Predicate<String> oddCountLetters = (name) -> name.length() % 2 != 0;
        Predicate<String> startWithA = (name) -> name.startsWith("A");
        Predicate<String> filters = oddCountLetters.or(startWithA);

        var result = Stream.of("Sevara", "Tom", "Ann").filter(filters).toList();
        System.out.println(result);

        UnaryOperator<String> ex = String::toUpperCase;

        System.out.println(ex.apply("John"));

        BinaryOperator<Integer> max = BinaryOperator.maxBy(Integer::compare);
        System.out.println(max.apply(10, 20));

        System.out.println(StringFilter.NON_EMPTY.test(""));
        System.out.println(StringFilter.STARTS_WITH_A.test("Alex"));
        System.out.println(StringFilter.LONGER_THAN_3.test("Bob"));

        System.out.println(DataSource.TIME.get());
        System.out.println(DataSource.UUID_GEN.get());
        System.out.println(DataSource.CONSTANT.get());

    }


}
