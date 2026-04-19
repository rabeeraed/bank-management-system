public class TransactionSystem {
    public static void Deposit(Account user_acc, double amount) {
        user_acc.Balance += amount;
        System.out.println("Deposit successful.");
    }

    public static void Withdraw(Account user_acc, double amount) {
        if (amount <= user_acc.Balance) {
            user_acc.Balance -= amount;
            System.out.println("Withdrawal Successful.");
        }
        else {
            System.err.println("Withdrawal declined. Not enough balance.");
        }
    }

    public static void Transfer(Account src_acc, Account destination_acc, double amount) {
        if (amount <= src_acc.Balance) {
            src_acc.Balance -= amount;
            destination_acc.Balance += amount;
            System.out.println("Tranfsfer successful.");
        }
        else {
            System.err.println("Transfer declined. Not enough balance.");
        }
    }
}