package lessons.lesson05;

public class Account {

    private double balance;

    public Account() {
        this.balance = 0;
    }

    public double getBalance() {
        return balance;
    }

    public void withdrawBalance(double balance) {
        if (this.balance >= balance) {}
        this.balance = this.balance - balance;
    }

    public void replenishBalance(double balance) {
        if (balance > 0) {
            this.balance = this.balance + balance;
        }
    }
}
