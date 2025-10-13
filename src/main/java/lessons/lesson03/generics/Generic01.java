package lessons.lesson03.generics;

public class Generic01<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}