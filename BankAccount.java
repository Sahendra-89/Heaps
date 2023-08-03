 import java.util.Scanner;
public class BankAccount {
   

// BankAccount class to represent the user's bank account

    private double balance;

    public void BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class to represent the ATM machine
class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public void withdraw(double amount) {
        boolean success = bankAccount.withdraw(amount);
        if (success) {
            System.out.println("Withdrawal successful. Current balance: " + bankAccount.getBalance());
        } else {
            System.out.println("Insufficient balance. Current balance: " + bankAccount.getBalance());
        }
    }

    public void deposit(double amount) {
        bankAccount.deposit(amount);
        System.out.println("Deposit successful. Current balance: " + bankAccount.getBalance());
    }

    public void checkBalance() {
        System.out.println("Current balance: " + bankAccount.getBalance());
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance set to 1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");

            int option = scanner.nextInt();
            double amount;

            switch (option) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        atm.withdraw(amount);
                    } else {
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    amount = scanner.nextDouble();
                    if (amount > 0) {
                        atm.deposit(amount);
                    } else {
                        System.out.println("Invalid amount. Please try again.");
                    }
                    break;
                case 3:
                    atm.checkBalance();
                    break;
                case 4:
                    System.out.println("Exiting the ATM. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

    

