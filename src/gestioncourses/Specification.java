/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package gestioncourses;

/**
 *
 * @author HANA
 */
public interface Specification<T> {
    boolean isSatisfiedBy(T item);
}