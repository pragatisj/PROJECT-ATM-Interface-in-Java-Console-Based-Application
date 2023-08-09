

import java.util.Map;
import java.util.Scanner;

public class ATM {
    private Bank bank;
    private Scanner scanner;

    public ATM(Bank bank) {
        this.bank = bank;
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        System.out.println("***WELCOME TO BANK!***");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter user PIN: ");
        String userPin = scanner.nextLine();

        AccountHolder accountHolder = bank.authenticateUser(userId, userPin);
        if (accountHolder != null) {
            System.out.println("Authentication successful.");
             System.out.println("---------------------------------------------------");
            showMenu(accountHolder);
        } else {
            System.out.println("Authentication failed.");
             System.out.println("---------------------------------------------------");
        }
    }

    private void showMenu(AccountHolder accountHolder) {
        while (true) {
            System.out.println("\n1. Create new account");
            System.out.println("2. Check balance");
            System.out.println("3. Show transaction history");
            System.out.println("4. Withdraw");
            System.out.println("5. Deposit");
            System.out.println("6. Transfer");
            System.out.println("7. Quit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter new account number: ");
                    String newAccountNumber = scanner.nextLine();
                    accountHolder.createAccount(newAccountNumber);
                    System.out.println("New account created successfully.");
                    System.out.println("---------------------------------------------------");
                    break;

                case 2:
                    System.out.println("Select an account:");
                    Map<String, Account> accounts = accountHolder.getAccounts();
                    for (String accountNumber : accounts.keySet()) {
                        System.out.println(accountNumber);
                    }
                    String selectedAccountNumber = scanner.nextLine();
                    Account selectedAccount = accounts.get(selectedAccountNumber);
                    if (selectedAccount != null) {
                        System.out.println("Balance: " + selectedAccount.getBalance());
                    } else {
                        System.out.println("Account not found.");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                case 3:
                    System.out.println("Select an account:");
                    Map<String, Account> accs = accountHolder.getAccounts();
                    for (String accNumber : accs.keySet()) {
                        System.out.println(accNumber);
                    }
                    String selectedAccNumber = scanner.nextLine();
                    Account selectedAcc = accs.get(selectedAccNumber);
                    if (selectedAcc != null) {
                        BankTransaction.showTransactionHistory(selectedAcc);
                    } else {
                        System.out.println("Account not found.");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                case 4:
                    System.out.println("Select an account:");
                    Map<String, Account> accMap = accountHolder.getAccounts();
                    for (String accNumber : accMap.keySet()) {
                        System.out.println(accNumber);
                    }
                    String accNumber = scanner.nextLine();
                    Account acc = accMap.get(accNumber);
                    if (acc != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        boolean success = acc.withdraw(withdrawalAmount);
                        if (success) {
                            System.out.println("Withdrawal successful.");
                        } else {
                            System.out.println("Insufficient balance.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                case 5:
                    System.out.println("Select an account:");
                    Map<String, Account> accMap2 = accountHolder.getAccounts();
                    for (String accNum : accMap2.keySet()) {
                        System.out.println(accNum);
                    }
                    String accNumber2 = scanner.nextLine();
                    Account acc2 = accMap2.get(accNumber2);
                    if (acc2 != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        acc2.deposit(depositAmount);
                        System.out.println("Deposit successful.");
                    } else {
                        System.out.println("Account not found.");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                case 6:
                    System.out.println("Select source account:");
                    Map<String, Account> sourceAccounts = accountHolder.getAccounts();
                    for (String accNum : sourceAccounts.keySet()) {
                        System.out.println(accNum);
                    }
                    String sourceAccNumber = scanner.nextLine();
                    Account sourceAcc = sourceAccounts.get(sourceAccNumber);
                    if (sourceAcc != null) {
                        System.out.println("Select target account:");
                        for (String accNum : sourceAccounts.keySet()) {
                            if (!accNum.equals(sourceAccNumber)) {
                                System.out.println(accNum);
                            }
                        }
                        String targetAccNumber = scanner.nextLine();
                        Account targetAcc = sourceAccounts.get(targetAccNumber);
                        if (targetAcc != null) {
                            System.out.print("Enter transfer amount: ");
                            double transferAmount = scanner.nextDouble();
                            sourceAcc.transfer(targetAcc, transferAmount);
                            System.out.println("Transfer successful.");
                        } else {
                            System.out.println("Target account not found.");
                        }
                    } else {
                        System.out.println("Source account not found.");
                    }
                    System.out.println("---------------------------------------------------");
                    break;

                case 7:
                    System.out.println("***Thank You For Visiting Bank!***");
                     System.out.println("---------------------------------------------------");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    System.out.println("---------------------------------------------------");
                    break;
            }
        }
    }
    
}
