package Lesson3;

import java.util.ArrayList;
import java.util.List;

public class OnlineStore {
    private String code;
    private String name;
    private double price;
    private int count;

    private static List<OnlineStore> storeList = new ArrayList<>();

    public OnlineStore(String code, String name, double price, int count) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.count = count;
    }

    public void addProduct(OnlineStore product) {
        storeList.add(product);
        System.out.printf("%s added.%n", product.name);
    }

    public void buyProduct(int quantity) {
        if (quantity > 0 && quantity <= count) {
            count -= quantity;
            System.out.printf("Bought %d of %s. Remaining: %s.%n", quantity, name, count);
        } else {
            System.out.println("Not enough.");
        }
    }

    public void getInfo() {
        System.out.printf("%s, %s, %s, %s.%n", code, name, price, count);
    }

    public void getProducts() {
        if (storeList.isEmpty()) {
            System.out.println("No products.");
        } else {
            for (OnlineStore product : storeList) {
                product.getInfo();
            }
        }
    }
}

