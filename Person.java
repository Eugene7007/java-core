package Lesson2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public abstract class Person {
    private String name;
    private String id;

    public abstract void printInfo();
}
