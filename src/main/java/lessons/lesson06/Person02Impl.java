package lessons.lesson06;

public class Person02Impl implements Person02 {

    @Override
    public void printName() throws JavaException {
        System.out.println("Person02Impl");
    }

    private void sss() {
        printName();
    }

    public static void main(String[] args) {
        Person02Impl person02 = new Person02Impl();
        person02.printName();
    }
}
