import java.util.*;

public class Bank {

    public static Account[] Accounts;
    public static Scanner reader = new Scanner(System.in);

    public Bank(String name) {
        if (Accounts == null) {
            Accounts = new Account[100];
        }
    }

    private long readLongInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                long value = reader.nextLong();
                reader.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                reader.nextLine(); // consume the invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static long readLongInputOptional(String prompt) {
        while (true) {
            try {
                System.out.print(prompt + " (leave blank to skip): ");
                String input = reader.nextLine();
                if (input.isEmpty()) {
                    return -1; // Return -1 to indicate "skip this field"
                }
                return Long.parseLong(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number or leave blank to skip.");
            }
        }
    }

    public static long readLongInputPublic(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                long value = reader.nextLong();
                reader.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                reader.nextLine(); // consume the invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static int readIntInputPublic(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                int value = reader.nextInt();
                reader.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                reader.nextLine(); // consume the invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    public static double readDoubleInputPublic(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                double value = reader.nextDouble();
                reader.nextLine(); // consume the newline
                return value;
            } catch (InputMismatchException e) {
                reader.nextLine(); // consume the invalid input
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private long generateAccountNo() {
        long num = 0;
        int num_Length = 8;
        for (int i = 0; i < num_Length; i++) {
            num = num * 10 + (long)(Math.random() * 10);
        }
        for (Account acc : Accounts) {
            if (acc != null && acc.AccountNo == num) {
                return generateAccountNo();
            }
        }
        return num;
    }

    private String newPassword() {
        return newPasswordHelper();
    }

    private String newPasswordHelper() {

        String pass = "";
        System.out.print("Enter new password: ");
        pass = reader.nextLine();

        if ( pass.length() < 12 ) {
            System.out.println("Password must be at least 12 characters long.");
            return newPasswordHelper();
        }

        boolean validPassword = false;
        for ( char c : pass.toCharArray() ) {
            if ( c >= 'A' && c <= 'Z' ) {
                validPassword = true;
                break;
            }
        }
        if (validPassword) {
            validPassword = false;
            for ( char c : pass.toCharArray() ) {
                if ( c >= 'a' && c <= 'z' ) {
                    validPassword = true;
                    break;
                }
            }
        }
        if (validPassword) {
            validPassword = false;
            for ( char c : pass.toCharArray() ) {
                if ( c >= '0' && c <= '9' ) {
                    validPassword = true;
                    break;
                }
            }
        }
        if (validPassword) {
            validPassword = false;
            for ( char c : pass.toCharArray() ) {
                if ( c == '@' || c == '#' || c == '$' || c == '%' || c == '&' || c == '*' ) {
                    validPassword = true;
                    break;
                }
            }
        }

        if ( !validPassword ) {
            System.out.println("Password must contain at least one uppercase letter, one lowercase letter, one digit and one special character.");
            return newPasswordHelper();
        }


        String confirm_pass = "";
        System.out.print("Confirm password: ");
        confirm_pass = reader.nextLine();
        if (pass.equals(confirm_pass)) {
            return pass;
        }
        else {
            System.out.println("Passwords do not match. Try again.");
            return newPasswordHelper();
        }
    }

    public void createAccount() {
        String name, address;
        long phone_num;
        System.out.print("Enter name: ");
        name = reader.nextLine();
        System.out.print("Enter address: ");
        address = reader.nextLine();
        phone_num = readLongInputPublic("Enter phone number: ");
        long acc_num = generateAccountNo();
        String pass = newPassword();

        Account new_acc = new Account(name, address, phone_num, acc_num, pass);
        for (int i = 0; i < Accounts.length; i++) {
            if (Accounts[i] == null) {
                Accounts[i] = new_acc;
                break;
            }
        }
        System.out.println("Account created successfully. Your account number is: " + acc_num);
    }

    public Account Login() {
        long acc_num;
        String pass;
        acc_num = readLongInput("Enter account number: ");
        System.out.print("Enter password: ");
        pass = reader.nextLine();

        for (Account acc : Accounts) {
            if (acc != null && acc.AccountNo == acc_num && acc.Password.equals(pass)) {
                System.out.println("Login successful.");
                return acc;
            }
        }
        System.out.println("Invalid account number or password. Try again.");
        return Login();
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }

    public void viewAccountInfo() {
        Account acc = Login();
        acc.getInfo();
    }

    public void updateAccountInfo() {
        Account acc = Login();
        String name, address;
        long phone_num;
        System.out.print("Enter new name (leave blank to skip): ");
        name = reader.nextLine();
        System.out.print("Enter new address (leave blank to skip): ");
        address = reader.nextLine();
        phone_num = readLongInputOptional("Enter new phone number");

        if (!name.isEmpty()) {
            acc.Name = name;
            System.out.println("Name updated.");
        }
        if (!address.isEmpty()) {
            acc.Address = address;
            System.out.println("Address updated.");
        }
        if (phone_num != -1) {
            acc.PhoneNo = phone_num;
            System.out.println("Phone number updated.");
        }
        System.out.println("Account info update completed.");
    }

    public void changePassword() {
        Account acc = Login();
        String new_pass = newPassword();
        acc.Password = new_pass;
    }
    
    public static void closeScanner() {
        reader.close();
    }

    public void deleteAccount() {
        Account acc = Login();
        for (int i = 0; i < Accounts.length; i++) {
            if (Accounts[i] == acc) {
                Accounts[i] = null;
                System.out.println("Account deleted successfully.");
                break;
            }
        }
    }


}