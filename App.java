package Lesson8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Shohjahon
 * @version 1.0
 */

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Queue<User> userQueue = new LinkedList<>();
        int[] sequenceCounter = {1};

        System.out.println("Enter user names (type 'done' to finish):");

        Stream.generate(() -> {
                    System.out.print("Enter user name: ");
                    return scanner.nextLine().trim();
                })
                .takeWhile(name -> !name.equalsIgnoreCase("done"))
                .forEach(name -> {
                    User user = new User(name, sequenceCounter[0]++);
                    userQueue.add(user);
                    System.out.println("Added to queue: " + user);
                });

        Optional.ofNullable(userQueue.poll())
                .ifPresentOrElse(
                        user -> System.out.println("Processing user: " + user),
                        () -> System.out.println("No users to process.")
                );

        System.out.println("\nEnter a series of numbers separated by spaces:");
        String input = scanner.nextLine();

        Set<Integer> uniqueNumbers = Arrays.stream(input.split("\\s+"))
                .filter(s -> s.matches("\\d+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Unique numbers: " + uniqueNumbers);

        Map<String, Book> bookMap = Stream.of(
                new Book("1984", "George Orwell", "978-0451524935"),
                new Book("The Odyssey", "Homer", "978-0140449266"),
                new Book("To Kill a Mockingbird", "Harper Lee", "978-0061120084")
        ).collect(Collectors.toMap(Book::getIsbn, b -> b));

        System.out.println("\nBooks in library:");
        bookMap.values().forEach(System.out::println);

        scanner.close();
    }
}
