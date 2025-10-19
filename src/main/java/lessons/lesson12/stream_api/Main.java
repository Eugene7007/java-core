package lessons.lesson12.stream_api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    private static List<Student> mathematics = Arrays.asList(
        new Student("Bob", 18),
        new Student("Ted", 17),
        new Student("Zeka", 19)
    );

    private static List<Student> physics = Arrays.asList(
        new Student("Alan", 19),
        new Student("Anne", 21),
        new Student("Davis", 21)
    );

    private static Course courseMathematics = new Course("mathematics", mathematics);
    private static Course coursePhysics = new Course("physics", physics);
    private static List<Course> courses = List.of(courseMathematics, coursePhysics);

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
//        for (String s : strings) {
//            if (s.equals("a"))
//                strings.remove(s);
//        }

        strings.removeIf(s -> s.equals("a"));

        createStream();
        reductionOperations();
    }

    private static void createStream() {
        List<Student> students = courses.stream()
            .flatMap(s -> s.getStudents().stream())
            .toList();

        List<Integer> topTwoAges = students.stream()
            .map(Student::getAge)
            .filter(a -> a >= 18)
            .distinct()
            .sorted((a1, a2) -> a2 - a1)
            .skip(1)
            .limit(2)
            .collect(Collectors.toList());

        System.out.println(topTwoAges);

        //peak
        System.out.println("------start peek------");
        courseMathematics.getStudents().stream().peek(s -> System.out.println("Hello, " + s.getName()));
        System.out.println("------end peek------");

        System.out.println();
        //foreach
        System.out.println("------start foreach------");
        courseMathematics.getStudents().stream().forEach(s -> System.out.println("Hello, " + s.getName()));
        System.out.println("------end foreach------");

        //max
        courseMathematics.getStudents().stream()
            .map(Student::getAge)
            .max(Comparator.comparing(a -> a))
            .ifPresent(a -> System.out.println("The maximum age is " + a));

        //min
        courseMathematics.getStudents().stream()
            .map(Student::getAge)
            .min(Comparator.comparing(a -> a))
            .ifPresent(a -> System.out.println("The minimum age is " + a));

        //findFirst
        physics.stream()
            .filter(s -> s.getAge() == 19)
            .findFirst()
            .map(Student::getName)
            .ifPresent(name -> System.out.println("findFirst: " + name));

        //findAny
        physics.stream()
            .filter(s -> s.getAge() == 19)
            .findAny()
            .map(Student::getName)
            .ifPresent(name -> System.out.println("findAny: " + name));

        // соответствие хотя бы одного элемента
        System.out.println("anymatch: "
            + physics.stream().anyMatch(s -> s.getName().equals("Alan")));

        // соответствие всех элементов
        System.out.println("allmatch: " + physics.stream().allMatch(s -> s.getAge() < 22));
        System.out.println("noneMatch: " + physics.stream().noneMatch(s -> s.getAge() > 20));

        Set<Integer> ageSet = physics.stream().map(Student::getAge).collect(Collectors.toSet());
        System.out.println("set: " + ageSet);

        Map<String, Integer> nameAndAgeMap = physics.stream().collect(Collectors.toMap(Student::getName, Student::getAge));
        System.out.println("map: " + nameAndAgeMap);

        System.out.println(physics.stream().map(Student::getName).collect(Collectors.joining(",")));

        List<String> words = List.of("apple", "banana", "apricot", "berry", "cat");

        // Grouping by first letter, but collecting values into a Set instead of a List
        Map<Character, Set<String>> groupedWordsAsSet = words.stream()
            .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.toSet()));

        System.out.println(groupedWordsAsSet);

        List<String> stringsByLength = Arrays.asList("this", "is", "a", "long", "list", "of",
            "strings", "to", "use", "as", "a", "demo");
        Map<Integer, List<String>> lengthMap = stringsByLength.stream()
            .collect(Collectors.groupingBy(String::length));
        lengthMap.forEach((k,v) -> System.out.printf("%d: %s%n", k, v));

        List<String> strings = Arrays.asList("this", "is", "a", "long", "list", "of",
            "strings", "to", "use", "as", "a", "demo");

        Map<Boolean, Long> numberLengthMap = strings.stream()
            .collect(Collectors.partitioningBy(s -> s.length() % 2 == 0,
                Collectors.counting()));
        numberLengthMap.forEach((k,v) -> System.out.printf("%5s: %d%n", k, v));
    }

    private static void reductionOperations() {
        // Операции редукции для потока IntStream
        String[] strings = "this is an array of strings".split(" ");
        int totalLength = Arrays.stream(strings).mapToInt(String::length).sum();
        System.out.println("Суммарная длина равна " + totalLength);
        OptionalDouble ave = Arrays.stream(strings).mapToInt(String::length).average();
        System.out.println("Средняя длина равна " + ave);
        OptionalInt max = Arrays.stream(strings).mapToInt(String::length).max();
        OptionalInt min = Arrays.stream(strings).mapToInt(String::length).min();
        System.out.println("Максимальная и минимальная длины равны " + max + " и " + min);
    }
}
