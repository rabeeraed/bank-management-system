public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("Yarmouk Bank");
        bank.createAccount();
        bank.createAccount();
        Account loggedIn = bank.Login();
        TransactionSystem.Deposit(loggedIn);
        TransactionSystem.Withdraw(loggedIn);
        TransactionSystem.Transfer(loggedIn);
        bank.viewAccountInfo();
        bank.updateAccountInfo();
        bank.logout();
        Bank.closeScanner();
    }
}