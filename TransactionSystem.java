public class TransactionSystem {
    public static void Deposit(Account user_acc) {
        int amount;
        Scanner reader = new Scanner(System.in);   
        System.out.print("Enter amount to deposit: ");
        amount = reader.nextInt();
        user_acc.Balance += amount;
        System.out.println("Deposit successful.\nYour current balance: " + user_acc.Balance);
    }

    public static void Withdraw(Account user_acc) {
        int amount;
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter amount to withdraw: ");
        amount = reader.nextInt();
        if (amount <= user_acc.Balance) {
            user_acc.Balance -= amount;
            System.out.println("Withdrawal Successful.\nYour current balance: " + user_acc.Balance);
        }
        else {
            System.err.println("Withdrawal declined. Not enough balance.");
        }
    }

    public static void Transfer(Account src_acc) {
        Account destination_acc = null;
        System.out.print("Enter destination account number: ");
        Scanner reader = new Scanner(System.in);   
        long dest_acc_num = reader.nextLong();
        Account destination_acc = null;
        for (Account acc : Bank.Accounts) {
            if (acc.AccountNo == dest_acc_num) {
                destination_acc = acc;
                break;
            }
        }
        if (destination_acc == null) {
            System.err.println("Invalid destination account number.");
            return;
        }
        double amount;
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter amount to transfer: ");
        amount = reader.nextDouble();
        if (amount <= src_acc.Balance) {
            src_acc.Balance -= amount;
            destination_acc.Balance += amount;
            System.out.println("Transfer successful.\nYour current balance: " + src_acc.Balance);
        }
        else {
            System.err.println("Transfer declined. Not enough balance.");
        }
    }
}