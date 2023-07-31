package homeworks.homework_3;

class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void transferFunds(BankAccount recipientAccount, double amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Некорректная сумма перевода");
        }

        if (amount > balance) {
            throw new InsufficientFundsException("Недостаточно средств на счете");
        }

        balance -= amount;
        recipientAccount.deposit(amount);
    }

    public void deposit(double amount) {
        balance += amount;
    }
}

public class Bank {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(500);

        try {
            account1.transferFunds(account2, 300);
            System.out.println("Перевод выполнен успешно!");
            System.out.println("Баланс на счете 1: " + account1.getBalance());
            System.out.println("Баланс на счете 2: " + account2.getBalance());
        } catch (InvalidAmountException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
