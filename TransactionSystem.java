public class TransactionSystem {
    public static void Deposit(Account user_acc) {
        int amount = Bank.readIntInputPublic("Enter amount to deposit: ");
        user_acc.Balance += amount;
        System.out.println("Deposit successful.\nYour current balance: " + user_acc.Balance);
    }

    public static void Withdraw(Account user_acc) {
        int amount = Bank.readIntInputPublic("Enter amount to withdraw: ");
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
        long dest_acc_num = Bank.readLongInputPublic("Enter destination account number: ");
        for (Account acc : Bank.Accounts) {
            if (acc != null && acc.AccountNo == dest_acc_num) {
                destination_acc = acc;
                break;
            }
        }
        if (destination_acc == null) {
            System.err.println("Invalid destination account number.");
            return;
        }
        double amount = Bank.readDoubleInputPublic("Enter amount to transfer: ");
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