package Lesson2;

public class Teacher extends Person {
    public Teacher(String name, String id) {
        super(name, id);
    }

    @Override
    public void printInfo() {
        System.out.printf("Instructor: %s (id %s).%n", getName(), getId());
    }
}
