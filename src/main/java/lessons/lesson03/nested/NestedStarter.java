package lessons.lesson03.nested;

public class NestedStarter {

    public static void main(String[] args) {
        double fine = Account.Fine.calculateFine(1000);

        System.out.println(fine);
    }
}
