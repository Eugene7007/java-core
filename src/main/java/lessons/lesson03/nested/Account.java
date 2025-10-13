package lessons.lesson03.nested;

public class Account {

    private String number;
    private double balance;

    public Account(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    static class Fine {

        public static final int FINE_RATIO = 3;

        public static double calculateFine(double balance) {
            return balance * FINE_RATIO;
        }
    }
}
