package lessons.lesson02;

import java.util.Scanner;

public class Main {

    // переменная
    // метод
    // класс

    // модификатор доступа + тип данных + нейминг
    private String name;
    public int age;
    protected double salary;

    // method модификатор доступа + возвращ значение || тип данных + нейминг метода(опционально параметры) {
    // }

    public int printAge(int age, String name) {
        // Hello
        return 111;
    }

    public int printName(int age, String name) {
        // Hello
        return 111;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Input number 1 : ");
        int num1 = in.nextInt();
        System.out.println("Input number 2 : ");
        int num2 = in.nextInt();

        System.out.println("Num2 " + num2 + " Num1 " + num1);
    }

    public static void inputOutput() {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a number: ");
        int num = in.nextInt();

        System.out.printf("Your number: %d \n", num);
        in.close();
    }

    // Арифметические
    public static void arithmetic() {
        Scanner in = new Scanner(System.in);

        System.out.print("Input a number: ");
        int incomeNumber = in.nextInt();

        System.out.println(incomeNumber + 5);
        //

        System.out.println("10 + 3 = " + (10 + 3));
        int a = 10;
        int b = 3;

        String str = "Hello ";
        System.out.println(str + "World!" + " ");

        System.out.println(a + b);  // 13 (сложение)
        System.out.println(a - b);  // 7  (вычитание)
        System.out.println(a * b);  // 30 (умножение)
        System.out.println(a / b);  // 3  (целочисленное деление)
        System.out.println(a % b);  // 1  (остаток от деления)
    }

    // Операторы присваивания
    public static void assignment() {
        int x = 5;
        x += 3; // эквивалентно x = x + 3; → 8
        x -= 2; // → 6
        x *= 4; // → 24
        x /= 6; // → 4
        x %= 3; // → 1
    }

    // Операторы сравнения
    public static void compare() {
        int a = 5, b = 10;
        System.out.println(a == b); // false
        System.out.println(a != b); // true
        System.out.println(a > b);  // false
        System.out.println(a < b);  // true
        System.out.println(a >= 5); // true
        System.out.println(b <= 10);// true
    }

    // Логические операторы
    public static void logical() {
        boolean x = true, y = false;
        System.out.println(x && y); // false (И)
        System.out.println(x || y); // true  (ИЛИ)
        System.out.println(!x);     // false (НЕ)
    }

    // Тернарный оператор
    public static void ternary() {
        int age = 20;
        String result = (age >= 18) ? "Adult" : "Child";
        System.out.println(result); // Adult
    }

    // Инкремент и декремент
    public static void incrementDecrement() {
        int n = 5;
        n = n + 1;

        System.out.println(n);
        n = n + 1;
        System.out.println(n);

        System.out.println(n++); // 5 (сначала вывод, потом +1)
        System.out.println(++n); // 7 (сначала +1, потом вывод)
        System.out.println(n--); // 7
        System.out.println(--n); // 5
    }

    public static void conditional() {
        int amount = 5;
        if (amount == 5) {
            // block 1
            System.out.println("I have 5 coins and go to buy an ice cream");
        } else {
            // block 2
            System.out.println("I have less than 5 coins and go to collect metal");
        }

        // if
        int age = 20;
        if (age >= 18) {
            System.out.println("You are an adult.");
        }

        // if else
        if (age >= 18) {
            System.out.println("You are an adult.");
        } else {
            System.out.println("You are underage.");
        }

        // if else if else
        int score = 75;
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 70) {
            System.out.println("Grade: B");
        } else {
            System.out.println("Grade: C");
        }

        // ternary
        String result = (age >= 18) ? "Adult" : "Minor";
        System.out.println(result); // Adult
    }

    public static void switchCase(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                System.out.println("One");
            case 2:
                System.out.println("Two");
            default:
                System.out.println("Other");
        }

        int day = 3;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            default:
                System.out.println("Other day");
        }

        String result = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Other day";
        };
        System.out.println(result);
    }

    public static void loops() {
        for (int i = 1; i < 9; i++) {

        }

        for (int i = 1; i < 9; i++) {
            System.out.printf("Квадрат числа %d равен %d \n", i, i * i);
        }

//        int i = 1;
//        for (; ;){
//            System.out.printf("Квадрат числа %d равен %d \n", i, i * i);
//        }

        int e = 1;
        for (; e < 9; ) {
            System.out.printf("Квадрат числа %d равен %d \n", e, e * e);
            e++;
        }

        // внешний цикл
        for (int k = 1; k <= 9; k++) {
            // внутренний цикл
            for (int l = 1; l <= 9; l++) {
                System.out.print(k * l);
                System.out.print('\t');
            }
            System.out.println(); // Перемещаемся на новую строку
        }

        int m = 6;
        while (m > 0) {
            System.out.println(m);
            m--;
        }

        for (int o = 0; o < 10; o++) {
            if (o == 5)
                break;
            System.out.println(o);
        }

        for (int s = 0; s < 10; s++) {
            if (s == 5)
                continue;
            System.out.println(s);
        }

        int name;

        int numes[];
        int[] numsss;

        int nums[];
        int[] nums2;


        nums = new int[4];  // массив из 4 чисел

        int[] nums3 = new int[]{1, 2, 3, 5};
        int[] nums4 = {1, 2, 3, 5};


        int[] nums5 = new int[4];
        // устанавливаем значения элементов массива
        nums5[0] = 1;
        nums5[1] = 2;
        nums5[2] = 4;
        nums5[3] = 100;

        // получаем значение третьего элемента массива
        System.out.println(nums5[2]);    // 4


        int[] nums6 = {1, 2, 3, 4, 5};
        int length = nums6.length;   // 5

        for (int g = 0; g < length; g++) {
            System.out.println(nums6[g]);
        }

    }
}