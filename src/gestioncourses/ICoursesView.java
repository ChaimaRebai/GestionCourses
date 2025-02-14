/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioncourses;

/**
 *
 * @author HANA
 */
public interface ICoursesView {
    void setController(CoursesController controller);
    String getNom();
    int getQuantite();
    int getSelectedIndex();
    void updateList(String article, int index);
    void removeArticle(int index);
}