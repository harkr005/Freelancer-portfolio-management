import javax.swing.*;
import java.awt.*;

public class ProfileScreen {
    public static void showProfile(String userEmail) {
        JFrame profileFrame = new JFrame("User Profile");
        profileFrame.setSize(400, 300);
        profileFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        profileFrame.setLayout(new GridLayout(4, 1, 10, 10));

        // Sample user data
        String name = "Harshit";
        String bio = "Freelance Developer specializing in web and app development.";

        JLabel nameLabel = new JLabel("Name: " + name, JLabel.CENTER);
        JLabel emailLabel = new JLabel("Email: " + userEmail, JLabel.CENTER);
        JLabel bioLabel = new JLabel("<html>Bio: " + bio + "</html>", JLabel.CENTER);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> profileFrame.dispose());

        profileFrame.add(nameLabel);
        profileFrame.add(emailLabel);
        profileFrame.add(bioLabel);
        profileFrame.add(closeButton);

        profileFrame.setVisible(true);
    }
}
