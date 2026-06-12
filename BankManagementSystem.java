import java.util.Scanner;

class BankAccount {

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            balance = initialBalance;
        } else {
            balance = 0;
            System.out.println("Invalid initial balance. Balance set to 0.");
        }
    }


    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully Deposited: ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println("Successfully Withdrawn: ₹" + amount);
        }
    }
}

public class BankManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Initial Balance: ");
        double initialBalance = sc.nextDouble();

        BankAccount account = new BankAccount(initialBalance);

        int choice;

        do {
            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    System.out.println("Current Balance: ₹" + account.getBalance());
                    break;
                case 4:
                    System.out.println("Thank you for using Bank Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);

        sc.close();
    }
}


// SAMPLE INPUT:
// Enter Initial Balance: 5000
// 1
// 2000
// 3
// 2
// 1500
// 3
// 4

// SAMPLE OUTPUT:

// Enter Initial Balance: 5000

// ===== BANK MENU =====
// 1. Deposit Money
// 2. Withdraw Money
// 3. Check Balance
// 4. Exit
// Enter your choice: 1
// Enter deposit amount: 2000
// Successfully Deposited: ₹2000.0

// ===== BANK MENU =====
// 1. Deposit Money
// 2. Withdraw Money
// 3. Check Balance
// 4. Exit
// Enter your choice: 3
// Current Balance: ₹7000.0

// ===== BANK MENU =====
// 1. Deposit Money
// 2. Withdraw Money
// 3. Check Balance
// 4. Exit
// Enter your choice: 2
// Enter withdrawal amount: 1500
// Successfully Withdrawn: ₹1500.0

// ===== BANK MENU =====
// 1. Deposit Money
// 2. Withdraw Money
// 3. Check Balance
// 4. Exit
// Enter your choice: 3
// Current Balance: ₹5500.0

// ===== BANK MENU =====
// 1. Deposit Money
// 2. Withdraw Money
// 3. Check Balance
// 4. Exit
// Enter your choice: 4
// Thank you for using Bank Management System.
