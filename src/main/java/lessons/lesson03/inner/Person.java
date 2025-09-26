package lessons.lesson03.inner;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Person {

    private int age;
    private String name;
    private Address address;

    public Person(int age, String name, String city, String street) {
        this.age = age;
        this.name = name;
        this.address = new Address(city, street);
    }

    @Override
    public String toString() {
        return "name = " + name + ", age = " + age + ", address = " + address;
    }

    @Data
    @AllArgsConstructor
    public class Address {

        private String city;
        private String street;

        @Override
        public String toString() {
            return "city: " + city + ", street: " + street;
        }
    }
}
