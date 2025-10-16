package Lesson2;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@AllArgsConstructor
public class AddQuestionCommand implements Command {
    private QuizManager manager;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Enter quiz id to add question to: ");
        String qid = scanner.nextLine().trim();
        Quiz quiz = manager.getQuiz(qid);
        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        System.out.println("1) Multiple choice");
        System.out.println("2) True/False");
        System.out.print("Choose question type: ");
        String choice = scanner.nextLine().trim();
        if (choice.equals("1")) {
            System.out.print("Enter prompt: ");
            String prompt = scanner.nextLine();
            System.out.print("Enter points: ");
            double points = Double.parseDouble(scanner.nextLine());
            System.out.print("How many options? ");
            int optCount = Integer.parseInt(scanner.nextLine());
            List<String> opts = new ArrayList<>();
            for (int i = 0; i < optCount; i++) {
                System.out.printf("Option %d: ", i + 1);
                opts.add(scanner.nextLine());
            }
            System.out.print("Enter correct option number (1-based): ");
            int correct = Integer.parseInt(scanner.nextLine()) - 1;
            MultipleChoiceQuestion mcq = new MultipleChoiceQuestion(prompt, points, opts, correct);
            quiz.addQuestion(mcq);
            System.out.println("Added MCQ.");
        } else if (choice.equals("2")) {
            System.out.print("Enter prompt: ");
            String prompt = scanner.nextLine();
            System.out.print("Enter points: ");
            double points = Double.parseDouble(scanner.nextLine());
            System.out.print("Correct answer (T/F): ");
            String tf = scanner.nextLine().trim().toUpperCase();
            boolean correct = tf.equals("T") || tf.equals("TRUE");
            TrueFalseQuestion tfq = new TrueFalseQuestion(prompt, points, correct);
            quiz.addQuestion(tfq);
            System.out.println("Added True/False question.");
        } else {
            System.out.println("Unknown type.");
        }
    }
}
