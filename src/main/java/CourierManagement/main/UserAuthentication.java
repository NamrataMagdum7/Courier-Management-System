package CourierManagement.main;

import java.util.Scanner;

public class UserAuthentication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String validUsername = "user";
        String validPassword = "pass123";

        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(validUsername) && enteredPassword.equals(validPassword)) {
            System.out.println("Login successful.");
        } else {
            System.out.println("Invalid credentials.");
        }

        scanner.close();
    }
}

