package Lesson2;

import lombok.Getter;

import java.util.List;
import java.util.Scanner;

@Getter
public class MultipleChoiceQuestion extends Question {
    private List<String> options;
    private int correctIndex; // zero-based

    public MultipleChoiceQuestion(String prompt, double points, List<String> options, int correctIndex) {
        super(prompt, points);
        this.options = options;
        this.correctIndex = correctIndex;
    }

    @Override
    public double ask(Scanner scanner) {
        printPrompt();
        for (int i = 0; i < options.size(); i++) {
            System.out.printf("  %d) %s%n", i + 1, options.get(i));
        }
        System.out.print("Your choice (enter number): ");
        String line = scanner.nextLine();
        int choice = -1;
        try {
            choice = Integer.parseInt(line.trim()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input; treated as wrong.");
            return 0.0;
        }
        if (choice == correctIndex) {
            System.out.println("Correct!");
            return getPoints();
        } else {
            System.out.printf("Wrong. Correct answer was: %s%n", options.get(correctIndex));
            return 0.0;
        }
    }
}
