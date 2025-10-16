package Lesson5;

/**
 * @author Shohjahon
 * @version 1.0
 */

public class App {
    public static void main(String[] args) {
        Teacher teacher = new Teacher("Shohjahon", "01");

        Course course = new Course("1", "Java", teacher);

        Student student1 = new Student("Ali", "001");
        Student student2 = new Student("Bob", "002");
        course.addStudent(student1);
        course.addStudent(student2);

        course.markAttendance("001", "2025-10-03", true);
        course.markAttendance("002", "2025-10-03", false);

        course.assignScore("001", 95.0);
        course.assignScore("002", 88.5);

        course.displayCourseDetails();

        student1.displayAttend();
        student2.displayAttend();
    }
}
