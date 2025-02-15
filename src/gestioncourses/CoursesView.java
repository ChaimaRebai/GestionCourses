package gestioncourses;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

/**
 * A modern and visually appealing view class for managing a list of articles.
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
        setSize(600, 450);
        setLocationRelativeTo(null); // Center the window on the screen

        // Use a modern look and feel
        try {
            UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatLightLaf()); // FlatLaf for modern UI
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // Create components
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(20, 20, 20, 20)); // Add padding

        // Input panel
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBorder(BorderFactory.createTitledBorder("Ajouter un article"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Add padding

        // Nom de l'article
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Nom de l'article:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        nomField = new JTextField(20);
        inputPanel.add(nomField, gbc);

        // Quantité
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        inputPanel.add(new JLabel("Quantité:"), gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.WEST;
        quantiteField = new JTextField(5);
        inputPanel.add(quantiteField, gbc);

        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        addButton = createButton("Ajouter", "add.png");
        updateButton = createButton("Modifier", "edit.png");
        deleteButton = createButton("Supprimer", "delete.png");
        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Article list panel
        JPanel listPanel = new JPanel(new BorderLayout());
        listPanel.setBorder(BorderFactory.createTitledBorder("Liste des articles"));
        listModel = new DefaultListModel<>();
        articleList = new JList<>(listModel);
        articleList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(articleList);
        listPanel.add(scrollPane, BorderLayout.CENTER);

        // Add panels to the main panel
        mainPanel.add(inputPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        mainPanel.add(listPanel, BorderLayout.SOUTH);

        // Add main panel to the frame
        add(mainPanel);

        // Make the frame visible
        setVisible(true);
    }

    /**
     * Creates a styled button with an icon.
     */
    private JButton createButton(String text, String iconPath) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        button.setFocusPainted(false);
        button.setBackground(new Color(0, 123, 255)); // Blue background
        button.setForeground(Color.WHITE); // White text
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding

        // Load icon (if available)
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
            button.setIcon(icon);
        } catch (Exception e) {
            // Icon not found, use text only
        }

        return button;
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