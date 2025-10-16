package Lesson2;

import java.util.HashMap;
import java.util.Map;

public class QuizManager {
    private Map<String, Quiz> quizzes = new HashMap<>();

    public void addQuiz(Quiz q) {
        quizzes.put(q.getId(), q);
    }

    public Quiz getQuiz(String id) {
        return quizzes.get(id);
    }

    public void listQuizzes() {
        if (quizzes.isEmpty()) {
            System.out.println("No quizzes available.");
            return;
        }
        System.out.println("Quizzes:");
        for (Quiz q : quizzes.values()) {
            q.printSummary();
        }
    }
}
