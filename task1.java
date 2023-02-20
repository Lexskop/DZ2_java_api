
/**
Задание №1: Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
 */
import java.util.Arrays;
import java.io.FileWriter;
import java.io.IOException;

public class task1 {
    public static void main(String[] args) {
        int[] arr = { 10, 2, 8, 1, 6, 5 };
        int tmp = 0;
        try (FileWriter writer = new FileWriter("task1.txt")) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr.length - 1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        tmp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = tmp;
                    }
                }
                writer.write(String.valueOf(Arrays.toString(arr)));
                writer.write("\n"); // Выведет строки файла с новой строки
                writer.flush();
            }
        } catch (IOException e) {
            e.printStackTrace(); // Выведет в консоль причину ошибки
        }
        System.out.println(Arrays.toString(arr));
    }
}