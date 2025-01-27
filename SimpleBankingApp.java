
import java.util.Scanner;

public class SimpleBankingApp {

    private static double accountBalance = 0.0; // Global variable for account balance

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        boolean isExiting = false;

        System.out.println("Welcome to the Simple Banking Application!");

        while (!isExiting) {
            // Display the menu
            displayMenu();

            System.out.print("Enter your choice: ");
            int userChoice = inputScanner.nextInt();

            switch (userChoice) {
                case 1: // Deposit funds
                    depositFunds(inputScanner);
                    checkAccountBalance();
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    return;

                case 2: // Withdraw funds
                    withdrawFunds(inputScanner);
                    checkAccountBalance();
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    return;

                case 3: // Check account balance
                    checkAccountBalance();
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    return;

                case 4: // Exit the application
                    System.out.println("Thank you for using the banking application. Goodbye!");
                    isExiting = true;
                    break;

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }

        inputScanner.close();
    }

    // Function to display the menu
    private static void displayMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Deposit Funds");
        System.out.println("2. Withdraw Funds");
        System.out.println("3. Check Account Balance");
        System.out.println("4. Exit");
    }

    // Function to handle deposits
    private static void depositFunds(Scanner scanner) {
        System.out.print("Enter the amount to deposit: ");
        double depositAmount = scanner.nextDouble();
        if (depositAmount > 0) {
            accountBalance += depositAmount;
            System.out.println("Rs." + depositAmount + " has been successfully deposited!");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }

    }

    // Function to handle withdrawals
    private static void withdrawFunds(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: ");
        double withdrawalAmount = scanner.nextDouble();
        if (withdrawalAmount > 0 && withdrawalAmount <= accountBalance) {
            accountBalance -= withdrawalAmount;
            System.out.println("Rs." + withdrawalAmount + " has been successfully withdrawn!");
        } else if (withdrawalAmount > accountBalance) {
            System.out.println("Insufficient balance in your account.");
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    // Function to check account balance
    private static void checkAccountBalance() {
        System.out.println("Your current account balance is: Rs." + accountBalance);
    }
}
