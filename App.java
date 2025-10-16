package Lesson2;

import lombok.Cleanup;

import java.util.Scanner;

/**
 * @author Shohjahon
 * @version 1.0
 */

public class App {
    public static void main(String[] args) {
        @Cleanup Scanner scanner = new Scanner(System.in);
        QuizManager manager = new QuizManager();

        boolean running = true;
        while (running) {
            System.out.println("1) Create quiz");
            System.out.println("2) Add question to quiz");
            System.out.println("3) List quizzes");
            System.out.println("4) Launch quiz (student takes quiz)");
            System.out.println("0) Exit");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    new CreateQuizCommand(manager, scanner).execute();
                    break;
                case "2":
                    new AddQuestionCommand(manager, scanner).execute();
                    break;
                case "3":
                    manager.listQuizzes();
                    break;
                case "4":
                    new LaunchQuizCommand(manager, scanner).execute();
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Unknown option.");
            }
        }

        System.out.println("Goodbye.");
    }
}
