/*
PLEASE DO NOT IGNORE THE PROVIDED FILE README.TXT
*/


import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner reader = new Scanner(System.in);
        long prompt_num;
        String prompt_pass;


        Account account1 = new Account(21286562,"YU@123", 1000);
        Account account2 = new Account(81167921,"PASS@123", 500);
        Account[] active_accounts = {account1,account2};

        System.out.println("Enter account number > ");
        prompt_num = reader.nextLong();
        reader.nextLine();
        boolean found = false;
        for (Account acc: active_accounts) {
            if (acc.AccountNo == prompt_num) {
                found = true;
                System.out.print("Enter password > ");
                prompt_pass = reader.nextLine();
                if (prompt_pass.equals(acc.Password)) {
                    System.out.println("Login Successfull");
                    System.out.println("Pick a number: 0.Deposit/1.Withdraw/2.Transfer > ");
                    int op = reader.nextInt();
                    reader.nextLine();
                    if (op == 0) {
                        System.out.println("Enter amount to deposit > ");
                        double amount = reader.nextDouble();
                        TransactionSystem.Deposit(acc,amount);                        
                    }
                    else if (op == 1) {
                        System.out.println("Enter amount to withdraw > ");
                        double amount = reader.nextDouble();
                        TransactionSystem.Withdraw(acc, amount);   
                    }
                    else if (op == 2) {
                        System.out.println("Transfer to Acc. No. >");
                        long transfer_to = reader.nextLong();
                        reader.nextLine();
                        boolean found_destination = false;
                        for (Account destination : active_accounts) {
                            if (destination.AccountNo == transfer_to) {
                                found_destination = true;
                                System.out.println("Enter transfer amount >");
                                double amount = reader.nextDouble();
                                TransactionSystem.Transfer(acc, destination, amount);
                                break;
                            }
                        }
                        if (found_destination = false) {
                            System.out.println("Destination account not found.");
                        }
                    }
                    else {
                        System.out.println("Please enter a valid operation number (0/1/2)");
                    }
                }
                else {
                    System.out.println("Authentication failed. Wrong credentials.");
                }
                break;
            }
        }
        if (found == false) {
            System.out.println("Account not found");
        }   
    }
}
