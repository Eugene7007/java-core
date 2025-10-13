package questshadow;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Shohjahon
 * @version 1.0
 */

public class Practice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //every10To100();
        //sumNum1ToN(scanner);
        //productNum1ToN(scanner);
        //evenNum1toN(scanner);
        //sumOfNumbers(scanner);
        //toReverse(scanner);
        //factorialOfN(scanner);
        //firstDivisible();
        //primeNumToN(scanner);
        //drawTriangle(scanner);
        //swaps(scanner);
        //multiplicationTable(scanner);
        //sumsToDollars(scanner);
        //findEvenOdd(scanner);
        //findLargest(scanner);
        //numberOperation(scanner);
        //findMiddle(scanner);
        //findNumber(scanner);
        //attemptsToGuess(scanner);

    }

    private static void attemptsToGuess(Scanner scanner) {
        Random rand = new Random();

        int secret = rand.nextInt(100) + 1;
        int attempts = 5;
        boolean guessed = false;

        System.out.println("Guess (between 1 and 100). You have " + attempts + " attempts.");

        for (int i = 1; i <= attempts; i++) {
            System.out.print("Attempt " + i + ": ");
            int guess = scanner.nextInt();

            if (guess == secret) {
                System.out.println("You guessed the number in " + i + " attempts.");
                guessed = true;
                break;
            } else if (guess < secret) {
                System.out.println("Too low!");
            } else {
                System.out.println("Too high!");
            }
        }

        if (!guessed) {
            System.out.println("The number was: " + secret);
        }
    }

    private static void findNumber(Scanner scanner) {
        System.out.print("Amount: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.print("Enter the number to search: ");
        int key = scanner.nextInt();

        boolean found = false;
        for (int num : arr) {
            if (num == key) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println(key + " is in the array.");
        } else {
            System.out.println(key + " is not in the array.");
        }
    }

    private static void findMiddle(Scanner scanner) {
        System.out.print("Amount: ");
        int n = scanner.nextInt();

        double[] arr = new double[n];
        double sum = 0;

        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextDouble();
            sum += arr[i];
        }

        double middle = sum / n;

        System.out.println(middle);
    }

    private static void numberOperation(Scanner scanner) {
        System.out.print("Number 1: ");
        double a = scanner.nextDouble();

        System.out.print("Number 2: ");
        double b = scanner.nextDouble();

        System.out.print("+, -, *, / ");
        char op = scanner.next().charAt(0);

        String result = String.valueOf(switch (op) {
            case '+' -> a + b;
            case '-' -> a - b;
            case '*' -> a * b;
            case '/' -> (b != 0) ? (a / b) : "Division by zero!";
            default -> "Invalid!";
        });

        System.out.println(result);
    }

    private static void findLargest(Scanner scanner) {
        System.out.print("Number 1: ");
        int a = scanner.nextInt();

        System.out.print("Number 2: ");
        int b = scanner.nextInt();

        System.out.print("Number 3: ");
        int c = scanner.nextInt();

        int largest = (a > b) ? (Math.max(a, c)) : (Math.max(b, c));

        System.out.println(largest);
    }

    private static void findEvenOdd(Scanner scanner) {
        System.out.print("Number: ");
        int number = scanner.nextInt();

        String result = (number % 2 == 0) ? "even" : "odd";

        System.out.println(result);
    }

    private static void sumsToDollars(Scanner scanner) {
        int exchange = 12500;

        System.out.print("Amount: ");
        double dollars = scanner.nextInt();

        double sums = dollars * exchange;

        System.out.println(sums);
    }

    private static void multiplicationTable(Scanner scanner) {
        System.out.println("Choose an option:");
        System.out.println("1. Multiplication table of a single number.");
        System.out.println("2. Multiplication tables from 1 to N.");
        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.print("Number: ");
            int num = scanner.nextInt();

            for (int i = 1; i <= 10; i++) {
                System.out.println(num + " x " + i + " = " + (num * i));
            }

        } else if (choice == 2) {
            System.out.print("Number: ");
            int N = scanner.nextInt();

            for (int n = 1; n <= N; n++) {
                for (int i = 1; i <= 10; i++) {
                    System.out.println(n + " x " + i + " = " + (n * i));
                }
                System.out.println();
            }

        } else {
            System.out.println("Invalid!");
        }
    }

    private static void swaps(Scanner scanner) {
        System.out.print("First number: ");
        int a = scanner.nextInt();
        System.out.print("Second number: ");
        int b = scanner.nextInt();

        int swap = a;
        a = b;
        b = swap;

        System.out.println(a + " " + b);
    }

    private static void drawTriangle(Scanner scanner) {
        System.out.print("Number: ");
        int num = scanner.nextInt();

        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void primenumToN(Scanner scanner) {
        System.out.print("Number: ");
        int N = scanner.nextInt();

        for (int num = 2; num <= N; num++) {
            boolean isPrime = true;

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) System.out.println(num + " ");
        }
    }

    private static void firstDivisible() {
        int start = 1000;

        while (start % 7 != 0) {
            start++;
        }

        System.out.println(start);
    }

    private static void factorialOfN(Scanner scanner) {
        System.out.print("Number: ");
        int num = scanner.nextInt();
        long factor = 1;

        int i = 1;
        while (i <= num) {
            factor *= i;
            i++;
        }

        System.out.println(factor);
    }

    private static void toReverse(Scanner scanner) {
        System.out.print("Number: ");
        int num = scanner.nextInt();
        String reversed = new StringBuilder(String.valueOf(num)).reverse().toString();
        System.out.println(reversed);
    }

    private static void sumOfNumbers(Scanner scanner) {
        System.out.print("Number: ");
        int N = scanner.nextInt();

        int sum = 0;

        while (N > 0) {
            int number = N % 10;
            sum += number;
            N /= 10;
        }

        System.out.println(sum);
    }

    private static void evenNum1toN(Scanner scanner) {
        System.out.print("Number: ");
        int N = scanner.nextInt();

        int sum = 0;

        for (int i = 2; i <= N; i++) {
            sum += i;
        }

        System.out.println(sum);
    }

    private static void productNum1ToN(Scanner scanner) {
        System.out.print("Number: ");
        int N = scanner.nextInt();

        long product = 1;

        for (int i = 1; i <= N; i++) {
            product *= i;
        }

        System.out.println(product);
    }

    private static void sumNum1ToN(Scanner scanner) {
        int N;

        System.out.print("Number: ");
        N = scanner.nextInt();

        int sum = N * (N + 1) / 2;

        System.out.println(sum);
    }

    private static void every10To100() {
        for (int i = 1; i <= 100; i++) {
            System.out.print(i + " ");

            if (i % 10 == 0) {
                System.out.println();
            }
        }
    }
}
