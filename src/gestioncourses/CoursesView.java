package gestioncourses;

import javax.swing.*;
import java.awt.*;

/**
 * A view class for managing a list of articles.
 */
class CoursesView extends JFrame implements ICoursesView {
    JTextField nomField;
    JTextField quantiteField;
    JButton addButton;
    JButton updateButton;
    JButton deleteButton;
    JList<String> articleList;
    DefaultListModel<String> listModel;

    private CoursesController controller;

    public CoursesView() {
        // Set up the frame
        setTitle("Gestion des Courses");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Center the window on the screen

        // Create components
        JPanel inputPanel = new JPanel(new GridBagLayout());
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JPanel listPanel = new JPanel(new BorderLayout());

        // Input fields with labels
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(new JLabel("Nom de l'article:"), gbc);

        gbc.gridx = 1;
        nomField = new JTextField(15);
        inputPanel.add(nomField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        inputPanel.add(new JLabel("Quantité:"), gbc);

        gbc.gridx = 1;
        quantiteField = new JTextField(5);
        inputPanel.add(quantiteField, gbc);

        // Buttons
        addButton = new JButton("Ajouter");
        updateButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Article list
        listModel = new DefaultListModel<>();
        articleList = new JList<>(listModel);
        JScrollPane scrollPane = new JScrollPane(articleList);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the frame
        setLayout(new BorderLayout());
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(listPanel, BorderLayout.SOUTH);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void setController(CoursesController controller) {
        this.controller = controller;
        addButton.addActionListener(e -> controller.ajouterArticle());
        updateButton.addActionListener(e -> controller.modifierArticle());
        deleteButton.addActionListener(e -> controller.supprimerArticle());
    }

    @Override
    public String getNom() {
        return nomField.getText();
    }

    @Override
    public int getQuantite() {
        try {
            return Integer.parseInt(quantiteField.getText());
        } catch (NumberFormatException e) {
            return -1; // Indicate invalid input
        }
    }

    @Override
    public int getSelectedIndex() {
        return articleList.getSelectedIndex();
    }

    @Override
    public void updateList(String article, int index) {
        if (index == -1) {
            listModel.addElement(article);
        } else {
            listModel.set(index, article);
        }
    }

    @Override
    public void removeArticle(int index) {
        listModel.remove(index);
    }

    public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}