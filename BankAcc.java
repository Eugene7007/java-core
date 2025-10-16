package Lesson3;

public class BankAcc {
    private String FIO;
    private String accNumber;
    private int balance;

    public BankAcc(String FIO, String accNumber, int balance) {
        this.FIO = FIO;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += (int) amount;
            System.out.printf("Deposit: %s. New balance: %s.", amount, balance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= (int) amount;
            System.out.printf("Withdrew: %s. New balance: %s.", amount, balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void print() {
        System.out.printf("%s, %s, %s.", FIO, accNumber, balance);
    }
}
