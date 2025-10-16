package Lesson5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public abstract class Person {
    private String name;
    private String id;

    public abstract void displayInfo();
}
