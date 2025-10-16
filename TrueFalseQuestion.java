package Lesson2;

import java.util.Scanner;

public class TrueFalseQuestion extends Question {
    private boolean correctAnswer;

    public TrueFalseQuestion(String prompt, double points, boolean correctAnswer) {
        super(prompt, points);
        this.correctAnswer = correctAnswer;
    }

    @Override
    public double ask(Scanner scanner) {
        printPrompt();
        System.out.print("Enter T or F: ");
        String line = scanner.nextLine().trim().toUpperCase();
        boolean answer;
        if (line.equals("T") || line.equals("TRUE")) answer = true;
        else if (line.equals("F") || line.equals("FALSE")) answer = false;
        else {
            System.out.println("Invalid input; treated as wrong.");
            return 0.0;
        }
        if (answer == correctAnswer) {
            System.out.println("Correct!");
            return getPoints();
        } else {
            System.out.println("Wrong.");
            return 0.0;
        }
    }
}
