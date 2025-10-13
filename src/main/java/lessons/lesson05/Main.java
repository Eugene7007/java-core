package lessons.lesson05;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Person person1 = new Student(20, "John", "226");
        Person person2 = new Teacher(30, "Mike", "mathematics");

        List<Person> persons = List.of(person1, person2);

        for (int i = 0; i < persons.size(); i++) {
            persons.get(i).sayHello();
        }
    }
}
