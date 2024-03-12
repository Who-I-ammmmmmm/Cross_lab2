import java.util.Scanner;

public class Task1 {
    public static void maxValue() {
        Scanner scanner = new Scanner(System.in);

        // Перевірка введених даних для першого числа
        float number1 = 0;
        boolean validInput1 = false;
        while (!validInput1) {
            System.out.println("Введіть перше число:");
            if (scanner.hasNextFloat()) {
                number1 = scanner.nextFloat();
                validInput1 = true;
            } else {
                System.out.println("Некоректне значення. Будь ласка, введіть число.");
                scanner.next(); // Очищення буфера вводу
            }
        }

        // Перевірка введених даних для другого числа
        float number2 = 0;
        boolean validInput2 = false;
        while (!validInput2) {
            System.out.println("Введіть друге число:");
            if (scanner.hasNextFloat()) {
                number2 = scanner.nextFloat();
                validInput2 = true;
            } else {
                System.out.println("Некоректне значення. Будь ласка, введіть число.");
                scanner.next(); // Очищення буфера вводу
            }
        }

        float sum = number1 + number2;
        float product = number1 * number2;
        float quotient = number2 != 0.0f ? number1 / number2 : Float.MAX_VALUE;
        float max = Math.max(Math.max(sum, product), quotient);

        System.out.println("Найбільше значення серед суми, добутку та частки: " + max);
    }
}
