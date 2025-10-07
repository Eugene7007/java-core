package lessons.lesson05;

public class Student extends Person {

    private String group;

    public Student(int age, String name, String group) {
        super(age, name);
        this.group = group;
    }

    @Override
    public void sayHello() {
        super.sayHello();
        System.out.println(" .I'm student");
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    @Override
    public String toString() {
        return super.toString() + "Student{" +
                "group='" + group + '\'' +
                '}';
    }
}
