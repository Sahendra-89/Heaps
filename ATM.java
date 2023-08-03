import java.util.Scanner;
public class ATM {
   
    private static double balance = 0;  // Initial balance is zero
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        
        while (!quit) {
            System.out.println("ATM Menu:");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Quit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                    
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                    
                case 3:
                    checkBalance();
                    break;
                    
                case 4:
                    quit = true;
                    break;
                    
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
            
            System.out.println();  // Print an empty line for separation
        }
        
        System.out.println("Thank you for using the ATM. Goodbye!");
    }
    
    private static void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful. Remaining balance: " + balance);
        }
    }
    
    private static void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount!");
        } else {
            balance += amount;
            System.out.println("Deposit successful. Updated balance: " + balance);
        }
    }
    
    private static void checkBalance() {
        System.out.println("Current balance: " + balance);
    }

    public void checkpin() {
    }
}

    

