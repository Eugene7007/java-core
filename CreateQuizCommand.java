package Lesson2;

import lombok.AllArgsConstructor;

import java.util.Scanner;

@AllArgsConstructor
public class CreateQuizCommand implements Command {
    private QuizManager manager;
    private Scanner scanner;

    @Override
    public void execute() {
        System.out.print("Enter quiz id: ");
        String id = scanner.nextLine().trim();
        System.out.print("Enter quiz title: ");
        String title = scanner.nextLine().trim();
        System.out.print("Teacher name: ");
        String iname = scanner.nextLine().trim();
        System.out.print("Teacher id: ");
        String iid = scanner.nextLine().trim();
        Teacher teacher = new Teacher(iname, iid);
        Quiz q = new Quiz(id, title, teacher);
        manager.addQuiz(q);
        System.out.println("Quiz created.");
    }
}
