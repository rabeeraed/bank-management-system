public class TransactionSystem {
    public void Deposit(Account user_acc, double amount) {
        user_acc.Balance += amount;
    }

    public void Withdraw(Account user_acc, double amount) {
        user_acc.Balance -= amount;
    }

    public void Transfer(Account src_acc, Account destination_acc, double amount) {
        src_acc.Balance -= amount;
        destination_acc.Balance += amount;
    }
}