import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ManageProjectsScreen {
    public static void manageProjects() {
        JFrame projectsFrame = new JFrame("Manage Projects");
        projectsFrame.setSize(500, 400);
        projectsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        projectsFrame.setLayout(new BorderLayout());

        // Project list
        ArrayList<String> projects = new ArrayList<>();
        projects.add("Portfolio Website");
        projects.add("Mobile App for Task Management");

        DefaultListModel<String> projectListModel = new DefaultListModel<>();
        projects.forEach(projectListModel::addElement);
        JList<String> projectList = new JList<>(projectListModel);
        JScrollPane scrollPane = new JScrollPane(projectList);

        // Input field and add button
        JPanel inputPanel = new JPanel(new FlowLayout());
        JTextField projectField = new JTextField(20);
        JButton addButton = new JButton("Add Project");

        addButton.addActionListener(e -> {
            String newProject = projectField.getText().trim();
            if (!newProject.isEmpty()) {
                projects.add(newProject);
                projectListModel.addElement(newProject);
                projectField.setText("");
            } else {
                JOptionPane.showMessageDialog(projectsFrame, "Project name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        inputPanel.add(projectField);
        inputPanel.add(addButton);

        // Buttons for Edit and Delete
        JPanel actionPanel = new JPanel(new FlowLayout());
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        // Edit functionality
        editButton.addActionListener(e -> {
            int selectedIndex = projectList.getSelectedIndex();
            if (selectedIndex != -1) {
                String newName = JOptionPane.showInputDialog(projectsFrame, "Edit Project Name:", projects.get(selectedIndex));
                if (newName != null && !newName.trim().isEmpty()) {
                    projects.set(selectedIndex, newName);
                    projectListModel.set(selectedIndex, newName);
                } else if (newName != null) {
                    JOptionPane.showMessageDialog(projectsFrame, "Project name cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(projectsFrame, "Please select a project to edit.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Delete functionality
        deleteButton.addActionListener(e -> {
            int selectedIndex = projectList.getSelectedIndex();
            if (selectedIndex != -1) {
                int confirm = JOptionPane.showConfirmDialog(projectsFrame, "Are you sure you want to delete this project?", "Confirm Delete", JOptionPane.YES_NO_OPTION);
                if (confirm == JOptionPane.YES_OPTION) {
                    projects.remove(selectedIndex);
                    projectListModel.remove(selectedIndex);
                }
            } else {
                JOptionPane.showMessageDialog(projectsFrame, "Please select a project to delete.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        actionPanel.add(editButton);
        actionPanel.add(deleteButton);

        // Add components to frame
        projectsFrame.add(scrollPane, BorderLayout.CENTER);
        projectsFrame.add(inputPanel, BorderLayout.NORTH);
        projectsFrame.add(actionPanel, BorderLayout.SOUTH);

        projectsFrame.setVisible(true);
    }
}
