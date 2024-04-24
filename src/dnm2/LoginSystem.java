package dnm2;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSystem {
	
	private static ArrayList<Users> users = new ArrayList<>();
	

    public static void main(String[] args) {
        // Adding some initial users
        users.add(new Users("admin", "1"));
        users.add(new Users("eylul", "2"));

        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            loggedIn = login(username, password);
            if (!loggedIn) {
                System.out.println("Invalid username or password. Please try again.");
            }
        }

        System.out.println("Login successful!");
        // Additional actions after successful login can be added here
    }

    private static boolean login(String username, String password) {
        for (Users user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
	
	
	

}
