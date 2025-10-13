package lessons.lesson03.inner;

public class PersonStarter {

    public static void main(String[] args) {
        Person ivan = new Person(25, "Ivan", "Tashkent", "Shota Rustaveli");
        ivan.setAge(25);
        ivan.setName("Ivan");

        System.out.println(ivan);
    }
}
