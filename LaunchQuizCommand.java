package Lesson2;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class LaunchQuizCommand implements Command {
    private QuizManager manager;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Enter quiz id to launch: ");
        String qid = scanner.nextLine().trim();
        Quiz quiz = manager.getQuiz(qid);

        if (quiz == null) {
            System.out.println("Quiz not found.");
            return;
        }

        System.out.print("Student name: ");
        String sname = scanner.nextLine().trim();
        System.out.print("Student id: ");
        String sid = scanner.nextLine().trim();
        Student student = new Student(sname, sid);
        quiz.launchForStudent(scanner, student);
    }
}
