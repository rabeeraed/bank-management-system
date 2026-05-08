import java.util.*;

public class Bank {

    String bankName;
    Account[] Accounts;

    public Bank(String name) {
        this.bankName = name;
    }

    private generateAccountNo() {
        long num = 0;
        int num_Length = 8;
        for (int i = 0; i < num_Length; i++) {
            num = num * 10 + (Math.random() % 10);
        }
        for (Account acc : Accounts) {
            if (acc.AccountNo == num) {
                return generateAccountNo();
            }
        }
        return num;
    }

    private newPassword() {

        String pass = "";
        Scanner reader = new Scanner(System.in);
        System.out.print("Enter new password: ");
        pass = reader.nextLine();

        if ( pass.length() < 12 ) {
            System.out.println("Password must be at least 12 characters long.");
            return newPassword();
        }

        for ( char c : pass.toCharArray() ) {
            boolean validPassword = true;
            if ( c >= 'A' && c <= 'Z' ) {
                validPassword = !validPassword;
            }
            else if ( c >= 'a' && c <= 'z' ) {
                validPassword = !validPassword;
            }
            else if ( c >= '0' && c <= '9' ) {
                validPassword = !validPassword;
            }
            else if ( c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' ) {
                validPassword = !validPassword;
            }
        }

        if ( !validPassword ) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one digit and one special character.");
            return newPassword();
        }


        String confirm_pass = "";
        System.out.print("Confirm password: ");
        confirm_pass = reader.nextLine();
        if (pass.equals(confirm_pass)) {
            return pass;
        }
        else {
            System.out.println("Passwords do not match. Try again.");
            return newPassword();
        }
    }

    public void createAccount() {
        Scanner reader = new Scanner(System.in);
        String name, address;
        long phone_num;
        System.out.print("Enter name: ");
        name = reader.nextLine();
        System.out.print("Enter address: ");
        address = reader.nextLine();
        System.out.print("Enter phone number: ");
        phone_num = reader.nextLong();
        long acc_num = generateAccountNo();
        String pass = newPassword();

        Account new_acc = new Account(name, address, phone_num, acc_num, pass);
        Accounts[Accounts.length] = new_acc;
    }

    public Account Login() {
        Scanner reader = new Scanner(System.in);
        long acc_num;
        String pass;
        System.out.print("Enter account number: ");
        acc_num = reader.nextLong();
        System.out.print("Enter password: ");
        pass = reader.nextLine();

        for (Account acc : Accounts) {
            if (acc.AccountNo == acc_num && acc.Password.equals(pass)) {
                return acc;
            }
        }
        System.out.println("Invalid account number or password. Try again.");
        return Login();
    }

    public logout() {
        Login = null;
        System.out.println("Logged out successfully.");
    }

    public void viewAccountInfo() {
        Account acc = Login();
        acc.getInfo();
    }

    public void updateAccountInfo() {
        Account acc = Login();
        Scanner reader = new Scanner(System.in);
        String name, address;
        long phone_num;
        System.out.print("Enter new name: ");
        name = reader.nextLine();
        System.out.print("Enter new address: ");
        address = reader.nextLine();
        System.out.print("Enter new phone number: ");
        phone_num = reader.nextLong();

        acc.Name = name;
        acc.Address = address;
        acc.PhoneNo = phone_num;
    }

    public void changePassword() {
        Account acc = Login();
        String new_pass = newPassword();
        acc.Password = new_pass;
    }

    public void deleteAccount() {
        Account acc = Login();
        Accounts[acc.AccountNo] = null;
    }


}