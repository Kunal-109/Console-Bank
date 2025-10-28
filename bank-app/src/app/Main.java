package app;

import Service.BankService;
import Service.imp.BankServiceImpl;
import domain.Account;

import java.util.Scanner;

public class Main {
    static void main() {
        Scanner scanner = new Scanner(System.in);
        BankService bankService = new BankServiceImpl();
        boolean running = true;
        System.out.println("Welcome to Console Bank");
        while(running){
            System.out.println("""
                1) Open Account
                2) Deposit
                3) Withdraw
                4) Transfer
                5) Account Statement
                6) Check Balance
                7) List Accounts
                8) Search Accounts by Customer Name
                0) Exit
            """);
            System.out.println("CHOOSE:");
            String choice  = scanner.nextLine().trim();
            System.out.println("CHOICE: "+ choice);

            switch(choice){
                case "0" -> {
                    running = false;
                    System.out.println("Thank you for choosing Console Bank");
                }
                case "1" -> openAccount(scanner ,bankService);
                case "2" -> depositAccount(scanner,bankService);
                case "3" -> withdraw(scanner, bankService);
                case "4" -> transfer(scanner,bankService);
                case "5" -> statement(scanner,bankService);
                case "6" -> balance(scanner,bankService);
                case "7" -> listAccounts(scanner,bankService);
                case "8" -> searchAccounts(scanner,bankService);

            }
        }

    }

    private static void balance(Scanner scanner, BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        bankService.getBalance(accountNumber);
    }

    private static void openAccount(Scanner scanner,BankService bankService) {
        System.out.println("Customer Name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Customer Email: ");
        String email = scanner.nextLine().trim();
        System.out.println("Account Type (SAVINGS/CURRENT): ");
        String type = scanner.nextLine().trim();
        System.out.println("Initial Deposit (optional , blank for 0): ");
        String amountStr = scanner.nextLine().trim();
        if(amountStr.isBlank()) amountStr = "0";
        Double initial = Double.valueOf(amountStr);
        String accountNumber = bankService.openAccount(name,email,type);
        if(initial>0)
            bankService.deposit(accountNumber , initial ,"INITIAL DEPOSIT");
        System.out.println("Account Opened: " + accountNumber);
    }

    private static void depositAccount(Scanner scanner,BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.deposit(accountNumber,amount,"Deposit");
        System.out.println("Deposited");
    }

    private static void withdraw(Scanner scanner ,BankService bankService) {
        System.out.println("Account Number: ");
        String accountNumber = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.withdraw(accountNumber,amount,"Withdrawal");
        System.out.println("Withdrawn");
    }

    private static void transfer(Scanner scanner ,BankService bankService) {
        System.out.println("From Account: ");
        String from = scanner.nextLine().trim();
        System.out.println("To Account: ");
        String to = scanner.nextLine().trim();
        System.out.println("Amount: ");
        Double amount = Double.valueOf(scanner.nextLine().trim());
        bankService.transfer(from , to , amount,"Transfer");
        System.out.println("Transferred");
    }

    private static void statement(Scanner scanner, BankService bankService) {
        System.out.println("Account number: ");
        String account = scanner.nextLine().trim();
        bankService.getStatement(account).forEach(t -> {
            System.out.println(t.getTimestamp() + " | " + t.getType() + " | " + t.getAmount()+ " | "+ t.getNote());
        });
    }

    private static void listAccounts(Scanner scanner , BankService bankService) {
        bankService.listAccounts().forEach(a -> {
            System.out.println(a.getAccountNumber()+ " | " + a.getAccountType() + " | " + a.getBalance());
        });
    }

    private static void searchAccounts(Scanner scanner , BankService bankService) {
        System.out.println("Customer Name contains: ");
        String q = scanner.nextLine().trim();
        bankService.searchAccountByCustomerName(q).forEach(account ->
                System.out.println(account.getAccountNumber() + " | "  + account.getAccountType() + " | "  + account.getBalance()));
    }
}
