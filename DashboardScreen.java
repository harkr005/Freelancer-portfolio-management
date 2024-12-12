import java.awt.*;
import javax.swing.*;
//import java.awt.event.*;

public class DashboardScreen {

    public static void showDashboard(String userEmail) {
        JFrame frame = new JFrame("Freelancer Portfolio Manager - Dashboard");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for better structure

        // Welcome message
        JLabel welcomeLabel = new JLabel("Welcome, " + userEmail + "!", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(welcomeLabel, BorderLayout.NORTH);

        // Buttons panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // 3 rows, 1 column, spacing of 10px

        JButton profileButton = new JButton("View Profile");
        JButton manageProjectsButton = new JButton("Manage Projects");
        JButton logoutButton = new JButton("Logout");

        // Add buttons to the panel
        buttonPanel.add(profileButton);
        buttonPanel.add(manageProjectsButton);
        buttonPanel.add(logoutButton);

        frame.add(buttonPanel, BorderLayout.CENTER);

        // Button functionality
        /*profileButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Profile details coming soon!", "Profile", JOptionPane.INFORMATION_MESSAGE);
        });*/

        /*manageProjectsButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "Manage projects feature coming soon!", "Projects", JOptionPane.INFORMATION_MESSAGE);
        });*/
        profileButton.addActionListener(e -> ProfileScreen.showProfile(userEmail));

        manageProjectsButton.addActionListener(e -> ManageProjectsScreen.manageProjects());

        logoutButton.addActionListener(e -> {
            frame.dispose(); // Close the dashboard screen
            Loginscreen.main(null); // Return to the login screen
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
