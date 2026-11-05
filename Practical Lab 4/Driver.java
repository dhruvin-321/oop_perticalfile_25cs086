import java.util.*;
class Driver
{
    public static void main(String[] a)
    {
        System.out.println("Please enter your password to ckeck");
        Scanner sc = new Scanner(System.in);
        String password = sc.next();
        System.out.println(PasswordChecker.getStrength(password));
    }
}