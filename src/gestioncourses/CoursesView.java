/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncourses;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author HANA
 */
class CoursesView extends JFrame implements ICoursesView {
    JTextField nomField, quantiteField;
    JButton addButton, updateButton, deleteButton;
    JList<String> articleList;
    DefaultListModel<String> listModel;

    private CoursesController controller;

    public CoursesView() {
        // Initialisation des composants
        nomField = new JTextField(15);
        quantiteField = new JTextField(5);
        addButton = new JButton("Ajouter");
        updateButton = new JButton("Modifier");
        deleteButton = new JButton("Supprimer");
        listModel = new DefaultListModel<>();
        articleList = new JList<>(listModel);
        
        // Mise en page
        setLayout(new FlowLayout());
        add(nomField);
        add(quantiteField);
        add(addButton);
        add(updateButton);
        add(deleteButton);
        add(new JScrollPane(articleList));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
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
        return Integer.parseInt(quantiteField.getText());
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
}
