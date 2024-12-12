import java.awt.*;
import javax.swing.*;

public class SignUpScreen {

    public static void showSignUpForm() {
        // Fetch customizations
       CustomizationSettings settings = CustomizationSettings.getInstance();

        JFrame frame = new JFrame("Freelancer Portfolio Manager - Sign-Up");
        frame.setSize(400, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(6, 2)); // 6 rows for the form fields and buttons

        // Apply background color to the frame
        frame.getContentPane().setBackground(settings.getBackgroundColor());

        // Input fields with custom fonts and colors
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(settings.getCustomFont());
        nameLabel.setForeground(settings.getTextColor());

        JTextField nameField = new JTextField();
        nameField.setFont(settings.getCustomFont());

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

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setFont(settings.getCustomFont());
        confirmPasswordLabel.setForeground(settings.getTextColor());

        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setFont(settings.getCustomFont());

        JButton submitButton = new JButton("Submit");
        submitButton.setFont(settings.getCustomFont());
        submitButton.setBackground(settings.getButtonColor());
        submitButton.setForeground(settings.getTextColor());

        JButton backButton = new JButton("Back");
        backButton.setFont(settings.getCustomFont());
        backButton.setBackground(settings.getButtonColor());
        backButton.setForeground(settings.getTextColor());

        // Submit button logic
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            char[] password = passwordField.getPassword();
            char[] confirmPassword = confirmPasswordField.getPassword();

            if (name.isEmpty() || email.isEmpty() || password.length == 0 || confirmPassword.length == 0) {
                JOptionPane.showMessageDialog(frame, "All fields are required!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (!String.valueOf(password).equals(String.valueOf(confirmPassword))) {
                JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(frame, "Sign-Up Successful! Welcome, " + name, "Success", JOptionPane.INFORMATION_MESSAGE);
                // Logic for saving user details can be added here.
                frame.dispose(); // Close the sign-up screen
                Loginscreen.main(null); // Return to login screen
            }
        });

        // Back button logic
        backButton.addActionListener(e -> {
            frame.dispose(); // Close the sign-up screen
            Loginscreen.main(null); // Return to login screen
        });

        // Add components to the frame
        frame.add(nameLabel);
        frame.add(nameField);
        frame.add(emailLabel);
        frame.add(emailField);
        frame.add(passwordLabel);
        frame.add(passwordField);
        frame.add(confirmPasswordLabel);
        frame.add(confirmPasswordField);
        frame.add(submitButton);
        frame.add(backButton);

        frame.setVisible(true);
    }
}
