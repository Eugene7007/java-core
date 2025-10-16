package Lesson3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BankSystem {
    private String accNumber;
    private String fullName;
    private double balance;

    private static List<BankSystem> accounts = new ArrayList<>();

    public BankSystem(String accNumber, String fullName, double balance) {
        this.accNumber = accNumber;
        this.fullName = fullName;
        this.balance = balance;
    }

    public void getInfo() {
        System.out.printf("%s, %s, %s.%n", accNumber, fullName, balance);
    }

    public static void addAcc(BankSystem bankAcc) {
        accounts.add(bankAcc);
        System.out.printf("%s added.%n", bankAcc.fullName);
    }

    public static void deleteAcc(String accNumber) {
        BankSystem accToRemove = findAcc(accNumber);
        if (accToRemove != null) {
            accounts.remove(accToRemove);
            System.out.printf("%s deleted.%n", accNumber);
        } else {
            System.out.println("Account not found.%n");
        }
    }

    private static BankSystem findAcc(String accNumber) {
        for (BankSystem acc : accounts) {
            if (acc.accNumber.equals(accNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void replenishAcc(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Replenish: %s. New balance: %s.%n", amount, balance);
        } else {
            System.out.println("Amount must be positive.%n");
        }
    }

    public static void showAllAcc() {
        if (accounts.isEmpty()) {
            System.out.println("No account.%n");
        } else {
            for (BankSystem acc : accounts) {
                acc.getInfo();
            }
        }
    }

    public static void transferBetweenAcc(String fromAcc, String toAcc, double amount) {
        BankSystem sender = findAcc(fromAcc);
        BankSystem receiver = findAcc(toAcc);

        if (sender == null || receiver == null) {
            System.out.println("Not found.%n");
        }

        if (amount >= 0 && Objects.requireNonNull(sender).balance >= amount) {
            sender.balance -= amount;
            assert receiver != null;
            receiver.balance += amount;
            System.out.printf("Transfer from %s to %s.%n", sender.fullName, receiver.fullName);
        } else {
            System.out.println("Fail.");
        }
    }
}
