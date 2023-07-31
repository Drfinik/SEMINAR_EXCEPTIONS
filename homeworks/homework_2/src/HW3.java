import java.util.InputMismatchException;
import java.util.Scanner;

public class HW3 {
    public static void main(String[] args) {
        // Задача № 1.
        Scanner sc = new Scanner(System.in);
        int a = getInt(sc, "Введите основание (целое число кроме 0): ");
        int b = getInt(sc, "Введите значение степени (положительное целое число): ");
        PowerCalculator pc = new PowerCalculator();
        try{
            System.out.printf("Результат вычисления: %s", pc.calculatePower(a, b));
        }catch (InvalidInputException ex){
            System.out.println(ex.getMessage());
        }
        sc.close();
    }

    public static int getInt(Scanner scanner, String message) {
        while (true) {
            try {
                System.out.print(message);
                return scanner.nextInt();
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: Введено некорректное число. Повторите ввод.");
                scanner.next(); // Очистка буфера сканера
            }
        }
    }
}

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class PowerCalculator {
    public double calculatePower(int a, int b) throws InvalidInputException {
        if (a == 0) {
            throw new InvalidInputException("Неккоректный ввод: основание равно нулю!");
        } else if (b < 0) {
            throw new InvalidInputException("Неккоректный ввод: значение степени меньше нуля!");
        }
        return Math.pow(a, b);

    }
}
