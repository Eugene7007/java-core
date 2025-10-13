package lessons.lesson03.interfaces;

public class InterfaceStarter {

    public static void main(String[] args) {
        Car.printInfoStatic();

        Bmw bmw = new Bmw();
        bmw.drive();
        bmw.printInfo();
        bmw.printInfoDefault();
    }
}
