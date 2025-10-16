package Lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Setter
@Getter
@AllArgsConstructor
public abstract class Question {
    private String prompt;
    private double points;

    public abstract double ask(Scanner scanner);

    protected void printPrompt() {
        System.out.println(getPrompt());
    }
}
