public class AuthenticationManager {
    public boolean SignIn(Account user_acc, String Password) {
        if (Password.equals(user_acc.Password)) {
            System.out.println("Sign In Successfull");
            return true;
        }
        System.out.print("Invalid login credentials.");
        return false;
    }
}