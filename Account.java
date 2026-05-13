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

    public void getInfo() {
        System.out.println("Name: " + this.Name);
        System.out.println("Address: " + this.Address);
        System.out.println("Phone number: " + this.PhoneNo);
        System.out.println("Account number: " + this.AccountNo);
        System.out.println("Balance: " + this.Balance);
    }
}