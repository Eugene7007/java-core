package Lesson2;

public class Student extends Person {
    public Student(String name, String id) {
        super(name, id);
    }

    @Override
    public void printInfo() {
        System.out.printf("Student: %s (id %s).%n", getName(), getId());
    }
}
