package GUI;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

public class Login extends JFrame {
	
    private static final ArrayList<Users> users = new ArrayList<>();

    private final JFrame frame;
    private final JTextField usernameField;
    private final JPasswordField passwordField;

    public Login() {
        
        users.add(new Users("eylul", "123"));
        users.add(new Users("zeynep", "123"));
        users.add(new Users("furkan","123"));

        frame = new JFrame("Book Management System");
        frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
        frame.setBounds(100, 100, 760, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
      
        JLabel lblNewLabel = new JLabel("Welcome to Book Management System Admin:");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel.setBounds(140, 78, 479, 50);
        frame.getContentPane().add(lblNewLabel);
        
        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setBounds(175, 149, 408, 229);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(28, 32, 99, 21);
        panel.add(lblUsername);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
                
        usernameField = new JTextField();
        usernameField.setBounds(175, 32, 193, 20);
        panel.add(usernameField);
        usernameField.setFont(new Font("Tahoma", Font.PLAIN, 15));
        usernameField.setColumns(10);
                        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(28, 77, 99, 21);
        panel.add(lblPassword);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                
        passwordField = new JPasswordField();
        passwordField.setBounds(175, 77, 193, 20);
        panel.add(passwordField);
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
                                        
        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(152, 141, 80, 49);
        panel.add(btnLogin);
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                                                    	
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (login(username, password)) {
                    JOptionPane.showMessageDialog(frame, "Login successful.");
                    // Additional actions after successful Login can be added here
                    frame.dispose(); // Close Login window
                    //create object
                    new Menu();
                                                            
                }
                else {
                    JOptionPane.showMessageDialog(frame, "Invalid username or password. Please try again.");

                }
            }
        });

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
                new Login();
                
            }
        });

}
}
