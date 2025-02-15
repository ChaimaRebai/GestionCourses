/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestioncourses;

import javax.swing.JOptionPane;

/**
 *
 * @author HANA
 */
public class GestionCourses {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        ListeCourses model = new ListeCourses(); // This should now work
        CoursesView view = new CoursesView();
        new CoursesController(model, view);
    }
        public void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
