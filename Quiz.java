package Lesson2;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {
    @Getter
    private String id;
    @Getter
    private String title;
    @Getter
    private Teacher teacher;
    private List<Question> questions = new ArrayList<>();

    public Quiz(String id, String title, Teacher teacher) {
        this.id = id;
        this.title = title;
        this.teacher = teacher;
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    public void removeQuestion(int index) {
        if (index >= 0 && index < questions.size()) questions.remove(index);
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public double launchForStudent(Scanner scanner, Student student) {
        System.out.printf("Quiz: %s (id %s)%n", title, id);
        teacher.printInfo();
        student.printInfo();
        double totalEarned = 0.0;
        double totalPossible = 0.0;
        for (int i = 0; i < questions.size(); i++) {
            System.out.printf("Question %d:%n", i + 1);
            Question q = questions.get(i);
            totalPossible += q.getPoints();
            double earned = q.ask(scanner);
            totalEarned += earned;
            System.out.println();
        }
        System.out.printf("Result for %s: %.2f / %.2f (%.1f%%)%n",
                student.getName(), totalEarned, totalPossible,
                (totalPossible == 0 ? 0 : (totalEarned / totalPossible * 100)));
        return totalEarned;
    }

    public void printSummary() {
        System.out.printf("Quiz %s (id %s) - %d questions%n", title, id, questions.size());
    }
}
