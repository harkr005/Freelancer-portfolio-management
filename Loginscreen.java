import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;

public class Loginscreen{

    public static void main(String[] args) {

        CustomizationSettings settings = CustomizationSettings.getInstance();
        
        JFrame frame = new JFrame("Freelancer Portfolio Manager - Login");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 2));

        frame.getContentPane().setBackground(settings.getBackgroundColor());

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(settings.getCustomFont());
        emailLabel.setForeground(settings.getTextColor());

        JTextField emailField = new JTextField();
        emailField.setFont(settings.getCustomFont());

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(settings.getCustomFont());
        passwordLabel.setForeground(settings.getTextColor());

        JPasswordField passwordField = new JPasswordField();
        passwordField.setFont(settings.getCustomFont());

        JRadioButton newUser = new JRadioButton("New User");
        newUser.setFont(settings.getCustomFont());
        newUser.setForeground(settings.getTextColor());
        newUser.setBackground(settings.getBackgroundColor());

        JRadioButton existingUser = new JRadioButton("Existing User", true);
        existingUser.setFont(settings.getCustomFont());
        existingUser.setForeground(settings.getTextColor());
        existingUser.setBackground(settings.getBackgroundColor());

        ButtonGroup userGroup = new ButtonGroup();
        userGroup.add(newUser);
        userGroup.add(existingUser);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(settings.getCustomFont());
        loginButton.setBackground(settings.getButtonColor());
        loginButton.setForeground(settings.getTextColor());

        JButton signUpButton = new JButton("Sign-Up");
        signUpButton.setFont(settings.getCustomFont());
        signUpButton.setBackground(settings.getButtonColor());
        signUpButton.setForeground(settings.getTextColor());

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            char[] password = passwordField.getPassword();

            if (email.isEmpty() || password.length == 0) {
                JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Login Successful for: " + email, "Login", JOptionPane.INFORMATION_MESSAGE);
                frame.dispose(); // Close the login screen
                DashboardScreen.showDashboard(email); // Open the Dashboard
            }
        });

        signUpButton.addActionListener(e -> {
            frame.dispose();
            SignUpScreen.showSignUpForm();
        });

        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(newUser);
        frame.add(existingUser);
        frame.add(loginButton);
        frame.add(signUpButton);

        frame.setVisible(true);
    }
}
