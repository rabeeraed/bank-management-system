public class Account {

    String Name;
    String Address;
    long PhoneNo;
    long AccountNo;
    String Password;
    double Balance;

    public Account(String name,
                    String address,
                    long phone_num,
                    long acc_num,
                    String pass)
    {
        this.Name = name;
        this.Address = address;
        this.PhoneNo = phone_num;
        this.AccountNo = acc_num;
        this.Password = pass;
        this.Balance = 0;
    }

}