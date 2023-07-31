import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HW1 {
    public static void main(String[] args) {
        // Задача 1. Проверка деления на ноль
        // Напишите программу, которая запрашивает у пользователя два целых числа и выполняет их деление.
        // Если второе число равно нулю, выбросите исключение ArithmeticException с сообщением
        // "Деление на ноль недопустимо". Иначе выведите результат деления на экран.
        Scanner sc = new Scanner(System.in);
        System.out.println("====== Задача № 1 ======");
        try {
            System.out.print("Введите первое целое число: ");
            int a = sc.nextInt();
            System.out.print("Введите второе целое число: ");
            int b = sc.nextInt();
            System.out.println("Результат вычисления: " + a / b);
        } catch (InputMismatchException e1) {
            System.out.println("Ошибка: некорректный ввод. Вводите целые числа!");
        } catch (ArithmeticException e2) {
            System.out.println("Деление на ноль недопустимо!");
        }
        sc.nextLine();
        System.out.println();

        // Обработка некорректного ввода
        // Напишите программу, которая запрашивает у пользователя его возраст. Если введенное
        // значение не является числом, выбросите исключение NumberFormatException
        // с сообщением "Некорректный ввод". Иначе выведите возраст на экран.

        System.out.println("====== Задача № 2 ======");
        while (true) {
            try {
                System.out.print("Введите ваш возраст: ");
                String userInput = sc.nextLine();
                int age = Integer.parseInt(userInput);
                if (age >= 0) {
                    System.out.println("Ваш возраст: " + age);
                    break;
                } else {
                    System.out.println("Введите положительное число!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Некорректный ввод!");
            }
        }
        System.out.println();
        sc.close();

        // Чтение файла и подсчет суммы чисел
        // Напишите программу, которая считывает содержимое текстового файла, в котором каждая
        // строка содержит одно число. Программа должна подсчитать сумму всех чисел в файле.
        // Если встретится строка, которая не может быть преобразована в число,
        // выбросите исключение NumberFormatException с сообщением "Некорректное значение числа в файле".
        System.out.println("====== Задача №3 ======");
        try {
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String line;
            int sum = 0;
            try {
                while ((line = br.readLine()) != null) {
                    try {
                        sum += Integer.parseInt(line);
                        System.out.println("Сумма чисел: " + sum);
                    } catch (NumberFormatException ex) {
                        System.out.println("Некорректное значение числа в файле!");
                    }
                }
            } catch (IOException ex) {
                System.out.println("Ошибка чтения файла!");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Файл не найден!");
        }
    }
}
