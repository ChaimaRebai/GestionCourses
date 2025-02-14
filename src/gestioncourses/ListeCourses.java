/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncourses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HANA
 */


public class ListeCourses implements ICoursesModel {
    private final List<Article> articles = new ArrayList<>();

    @Override
    public void ajouter(Article article) {
        articles.add(article);
    }

    @Override
    public void modifier(int index, String nom, int quantite) {
        if (index >= 0 && index < articles.size()) {
            articles.get(index).setNom(nom);
            articles.get(index).setQuantite(quantite);
        }
    }

    @Override
    public void supprimer(int index) {
        if (index >= 0 && index < articles.size()) {
            articles.remove(index);
        }
    }

    public List<Article> getArticles() {
        return new ArrayList<>(articles);
    }
}
