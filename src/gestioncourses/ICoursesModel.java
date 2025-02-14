/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioncourses;

import java.util.List;

/**
 *
 * @author HANA
 */
public interface ICoursesModel {
    void ajouter(Article article);
    void modifier(int index, String nom, int quantite);
    void supprimer(int index);
    List<Article> getArticles();
}