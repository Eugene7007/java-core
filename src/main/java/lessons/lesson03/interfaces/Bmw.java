package lessons.lesson03.interfaces;

import java.util.Objects;

public class Bmw implements Car {

    private int tank;
    private int speed;

    public Bmw() {
    }

    public Bmw(int tank, int speed) {
        this.tank = tank;
        this.speed = speed;
    }

    @Override
    public void drive() {

    }

    @Override
    public void printInfoDefault() {
        Car.super.printInfoDefault();
    }

    @Override
    public void printInfo() {
        System.out.println(this);
    }

    public int getTank() {
        return tank;
    }

    public void setTank(int tank) {
        this.tank = tank;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bmw bmw = (Bmw) o;
        return tank == bmw.tank && speed == bmw.speed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(tank, speed);
    }

    @Override
    public String toString() {
        return "Bmw{" + "tank=" + tank + ", speed=" + speed + '}';
    }
}

