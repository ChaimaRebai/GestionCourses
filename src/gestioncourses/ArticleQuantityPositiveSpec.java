/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestioncourses;

/**
 *
 * @author HANA
 */
public class ArticleQuantityPositiveSpec implements Specification<Article> {
    @Override
    public boolean isSatisfiedBy(Article article) {
        return article.getQuantite() > 0;
    }
}