public class Account {

    long AccountNo;
    String Password;
    double Balance;

    public Account(long num, String pass) {
        this.AccountNo = num;
        this.Password = pass;
        this.Balance = 0;
    }

    public Account(long num, String pass, double balance) {
        this.AccountNo = num;
        this.Password = pass;
        this.Balance = balance;
    }

}