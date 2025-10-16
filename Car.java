package Lesson3;

public class Car {
    private String country;
    private String model;
    private int yearOfManufacture;

    public Car(String country, String model, int yearOfManufacture) {
        this.country = country;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void print() {
        System.out.printf("%s, %s, %s.", country, model, yearOfManufacture);
    }
}
