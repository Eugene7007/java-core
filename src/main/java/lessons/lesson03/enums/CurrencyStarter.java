package lessons.lesson03.enums;

public class CurrencyStarter {

    public static void main(String[] args) {
        System.out.println("Name : " + Currency.EUR.name());
        System.out.println("Order : " + Currency.EUR.ordinal());
        System.out.println("To string : " + Currency.EUR);
        System.out.println("Scale : " + Currency.EUR.scale);
        System.out.println("Description : " + Currency.EUR.description);
    }
}
