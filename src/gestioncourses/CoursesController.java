/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncourses;

import javax.swing.JOptionPane;


/**
 *
 * @author HANA
 */
public class CoursesController {
    private final ListeCourses model;
    private final CoursesView view;

    // Define specifications
    private final Specification<Article> articleValidationSpec = 
        new AndSpecification<>(new ArticleNameNotEmptySpec(), new ArticleQuantityPositiveSpec());

     public CoursesController(ListeCourses model, CoursesView view) {
        this.model = model;
        this.view = view;

        view.addButton.addActionListener(e -> ajouterArticle());
        view.updateButton.addActionListener(e -> modifierArticle());
        view.deleteButton.addActionListener(e -> supprimerArticle());
    }


/*
    CoursesController(ICoursesModel model, ICoursesView view) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    */

    void ajouterArticle() {
        String nom = view.nomField.getText();
        int quantite;
        
        try {
            quantite = Integer.parseInt(view.quantiteField.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Quantité invalide !");
            return;
        }

        Article article = new Article(nom, quantite);

        if (articleValidationSpec.isSatisfiedBy(article)) {
            model.ajouter(article);
            view.listModel.addElement(nom + " - " + quantite);
        } else {
            JOptionPane.showMessageDialog(view, "Nom invalide ou quantité <= 0 !");
        }

    }

    void modifierArticle() {
        int index = view.articleList.getSelectedIndex();
        if (index != -1) {
            String nom = view.nomField.getText();
            int quantite;
            
            try {
                quantite = Integer.parseInt(view.quantiteField.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(view, "Quantité invalide !");
                return;
            }

            Article article = new Article(nom, quantite);

            if (articleValidationSpec.isSatisfiedBy(article)) {
                model.modifier(index, nom, quantite);
                view.listModel.set(index, nom + " - " + quantite);
            } else {
                JOptionPane.showMessageDialog(view, "Nom invalide ou quantité <= 0 !");
            }
        }
    }

    void supprimerArticle() {
        int index = view.articleList.getSelectedIndex();
        if (index != -1) {
            model.supprimer(index);
            view.listModel.remove(index);
        }
    }
}