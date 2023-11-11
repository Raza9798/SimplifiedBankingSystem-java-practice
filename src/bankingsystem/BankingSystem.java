/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package bankingsystem;

import jdk.jshell.spi.ExecutionControl;

import java.util.Scanner;

/**
 *
 * @author RAZA 9798
 */

/*
    Create a simplified banking system in Java. Define an abstract class "Account" 
    with methods for deposit and withdrawal, and then create concrete subclasses for 
    "SavingsAccount" and "CheckingAccount" that implement these methods differently.
 */
abstract class Account {
    public double Deposit(double amount, double current_balance) {
        return current_balance + amount;
    }

    public double Withdrawal(double amount, double current_balance) {
        return current_balance - amount;
    }
}

class SavingAccount extends Account {
    int option_type, account_number;
    double payment_amount, current_balance, amount;
    String account_holder_name;
    SavingAccount(int option_type, int account_number, String account_holder_name,  double payment_amount, double current_balance) {
        this.option_type = option_type;
        this.account_number = account_number;
        this.payment_amount = payment_amount;
        this.current_balance = current_balance;
        this.account_holder_name = account_holder_name;
        this.amount = 0;
        paymentHandling();
    }

    void paymentHandling() {
        try {
            if (this.option_type == 1) {
                this.amount = this.Deposit(this.payment_amount, this.current_balance);
            } else if (this.option_type == 2) {
                this.amount = this.Withdrawal(this.payment_amount, this.current_balance);
            }
            responseReceipt();
        }
        catch (Exception e) {
            System.out.println("SOMETHING WENT WRONG...");
        }
    }

    public void responseReceipt(){
        String type;
        if (this.option_type == 1) {
            type = "DEPOSITED";
        } else {
            type = "WITHDRAWAL";
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
        System.out.println("BANKING SYSTEM REPORT ");
        System.out.println("=============================");
        System.out.println("ACCOUNT NUMBER : " + this.account_number);
        System.out.println("ACCOUNT HOLDER NAME : " + this.account_holder_name);
        System.out.println("OPTION TYPE : " + type);
        System.out.println("PROCESSING AMOUNT : " + this.payment_amount);
        System.out.println("ACCOUNT BALANCE : " + this.amount);
    }
}

class CheckingAccount extends Account{
    String UserAccount(int account_number) {
        String name;
        if (account_number == 123) {
            name = "Mohamed";
        } else if (account_number == 456) {
            name = "Raza";
        } else if (account_number == 789) {
            name = "David";
        }
        else {
            name = "In valid account number";
        }
        System.out.println("ACCOUNT HOLDER NAME : " + name);
        return name;
    }
    double Balance(double account_number) {
        if (account_number == 123) {
            return 500;
        } else if (account_number == 456) {
            return 100;
        } else if (account_number == 789) {
            return 200;
        } else {
            return 0;
        }
    }
}

public class BankingSystem {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ENTER THE ACCOUNT NUMBER: ");
        int account_number = scanner.nextInt();

        CheckingAccount CheckingAccount = new CheckingAccount();
        String account_name = CheckingAccount.UserAccount(account_number);
        double current_balance = CheckingAccount.Balance(account_number);

        System.out.print("PLEASE CHOOSE AN OPTION - [1] Deposit | [2] Withdrawal : ");
        int option_type = scanner.nextInt();

        System.out.print("PLEASE ENTER THE AMOUNT : ");
        double amount = scanner.nextDouble();

        scanner.close();
        new SavingAccount(option_type, account_number,account_name,  amount, current_balance);
    }
}
