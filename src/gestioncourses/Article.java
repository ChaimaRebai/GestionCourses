/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncourses;

/**
 *
 * @author HANA
 */
public class Article {
    private String nom;
    private int quantite;

    public Article(String nom, int quantite) {
        this.nom = nom;
        this.quantite = quantite;
    }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public int getQuantite() { return quantite; }
    public void setQuantite(int quantite) { this.quantite = quantite; }
}


