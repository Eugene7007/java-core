package Lesson5;

public class Teacher extends Person {
    public Teacher(String name, String id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Instructor: " + getName() + " (ID: " + getId() + ")");
    }
}
