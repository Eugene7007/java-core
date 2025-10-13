package lessons.lesson05;

public class Teacher extends Person {

    private String subject;

    public Teacher(int age, String name, String subject) {
        super(age, name);
        this.subject = subject;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println(" .I'm teacher");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return super.toString() + "Teacher{" +
                "subject='" + subject + '\'' +
                '}';
    }
}
