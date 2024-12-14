import java.util.Scanner;

class BankAccount {
    private double balance;

    // Constructor to initialize the account with an initial balance
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Initial balance cannot be negative. Setting balance to 0.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }

    // Method to get the current balance
    public double getBalance() {
        return balance;
    }

    // Method to deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Deposit amount must be greater than 0.");
        }
    }

    // Method to withdraw money from the account
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Withdrawal failed.");
            return false;
        } else {
            System.out.println("Withdrawal amount must be greater than 0.");
            return false;
        }
    }
}

class ATM {
    private BankAccount account;

    // Constructor to associate an ATM with a BankAccount
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to display the ATM menu and process user input
    public void start() {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = s.nextInt();

            switch (choice) {
                case 1: // Check balance
                    System.out.println("Your current balance is: $" + account.getBalance());
                    break;
                case 2: // Deposit
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = s.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 3: // Withdraw
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = s.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 4: // Exit
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    s.close();
                    return;
                default: // Invalid option
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

public class ATMInterface {
    public static void main(String[] args) {
        // Initialize a BankAccount with an initial balance
        BankAccount userAccount = new BankAccount(500.0); // Starting with $500

        // Create an ATM instance associated with the user's account
        ATM atm = new ATM(userAccount);

        // Start the ATM application
        atm.start();
    }
}
