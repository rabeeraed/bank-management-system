public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Yarmouk Bank");
        bank.createAccount();
        bank.createAccount();
        bank.login();
        TransactionSystem.Deposit(bank.Login);
        TransactionSystem.Withdraw(bank.Login);
        TransactionSystem.Transfer(bank.Login);
        bank.viewAccountInfo();
        bank.updateAccountInfo();
        bank.logout();
    }
}