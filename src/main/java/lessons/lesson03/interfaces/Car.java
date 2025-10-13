package lessons.lesson03.interfaces;

public interface Car {

    void drive();
    void printInfo();

    static void printInfoStatic(){
        System.out.println("Static method for interface Car");
    }

    default void printInfoDefault(){
        System.out.println("Default method for interface Car");
    }
}