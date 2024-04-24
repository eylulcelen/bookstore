package dnm2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.GridLayout;

public class login2 extends JFrame {
	
    private static ArrayList<Users> users = new ArrayList<>();

    private JFrame frame;
    private JTextField usernameField;
    private JPasswordField passwordField;

    public login2() {
        
        users.add(new Users("admin", "123"));
        users.add(new Users("dilara", "1103"));

        frame = new JFrame("Book Management System");
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
        frame.setBounds(100, 100, 560, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setBounds(114, 139, 99, 21);
        frame.getContentPane().add(lblUsername);

        usernameField = new JTextField();
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usernameField.setBounds(223, 140, 193, 20);
        frame.getContentPane().add(usernameField);
        usernameField.setColumns(10);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(114, 196, 99, 21);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        passwordField.setBounds(223, 197, 193, 20);
        frame.getContentPane().add(passwordField);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLogin.setBounds(215, 248, 80, 39);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (login(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful.");
                    // Additional actions after successful login can be added here
                    frame.dispose(); // Close login window
                    //create object
                    new menu2();
                    
                } 
                else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.");
                  
                }
            }
        });
        
        frame.getContentPane().add(btnLogin);
      
        JLabel lblNewLabel = new JLabel("Welcome to Book Management System Admin:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(88, 67, 358, 50);
        frame.getContentPane().add(lblNewLabel);

        frame.setVisible(true);
    }

    private boolean login(String username, String password) {
        for (Users user:users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login2();
                
            }
        });

}
}
