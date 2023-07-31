package homeworks.homework_3;

import java.util.Scanner;

class InvalidInputException extends Exception {
    public InvalidInputException(String message) {
        super(message);
    }
}

class PowerCalculator {
    public static double calculatePower(double base, double exponent) throws InvalidInputException {
        if (base == 0 && exponent < 0) {
            throw new InvalidInputException("Invalid input: base cannot be zero and exponent cannot be negative");
        }
        return Math.pow(base, exponent);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the base number: ");
            double base = scanner.nextDouble();

            System.out.print("Enter the exponent number: ");
            double exponent = scanner.nextDouble();

            double result = PowerCalculator.calculatePower(base, exponent);
            System.out.println("Result: " + result);
        } catch (InvalidInputException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: Invalid input");
        }

        scanner.close();
    }
}