
/*
Задание №2: К калькулятору из предыдущего дз добавить логирование.
 */
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.Writer;

public class task2 {
    public static void main(String[] args) {
        Scanner iScanner = new Scanner(System.in);
        System.out.println("Введите число A: ");
        double num_a = iScanner.nextDouble();
        iScanner.nextLine();
        System.out.println("Введите действие (любой знак: + - * /): ");
        String action = iScanner.nextLine();
        String result = "";
        System.out.println("Введите число B: ");
        double num_b = iScanner.nextDouble();
        try (Writer FileWriter = new FileWriter("task2.txt", true)) {
            switch (action) {
                case "+":
                    System.out.printf("Ответ: %s\n", num_a + num_b);
                    result = String.format("Дано %s %s %s. Ответ: %s", num_a, action, num_b, num_a + num_b);
                    break;

                case "-":
                    System.out.printf("Ответ: %s\n", num_a - num_b);
                    result = String.format("Дано: %s %s %s. Ответ: %s", num_a, action, num_b, num_a - num_b);
                    break;

                case "*":
                    System.out.printf("Ответ: %s\n", num_a * num_b);
                    result = String.format("Дано: %s %s %s. Ответ: %s", num_a, action, num_b, num_a * num_b);
                    break;

                case "/":
                    System.out.printf("Ответ: %s\n", num_a / num_b);
                    result = String.format("Дано: %s %s %s. Ответ: %s", num_a, action, num_b, num_a / num_b);
                    break;

                default:
                    System.out.println("Введите правильное действие");
                    result = String.format("Дано: %s %s %s. Ответ: Введено неверное действие", num_a, action, num_b);
                    break;
            }
            FileWriter.write(result); // Сохраняет в файл, не затирая предыдущую информацию
            FileWriter.write("\n");
        } catch (IOException e) {
            e.printStackTrace(); // Выведет в консоль причину ошибки
        }
        iScanner.close();
    }
}