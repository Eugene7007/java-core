package lessons.lesson03.generics;

public class Generic04Impl implements Generic04<String, Integer> {

    @Override
    public String getT(Integer value) {
        return value.toString();
    }
}

 