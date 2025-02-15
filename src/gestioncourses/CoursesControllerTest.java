package gestioncourses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CoursesControllerTest {

    private ListeCourses model;
    private CoursesView view;
    private CoursesController controller;

    @BeforeEach
    void setUp() {
        // Mock the dependencies
        model = Mockito.mock(ListeCourses.class);
        view = Mockito.mock(CoursesView.class);
doNothing().when(view).showMessageDialog(anyString());

        // Mock the UI components
        when(view.nomField.getText()).thenReturn("Test Article");
        when(view.quantiteField.getText()).thenReturn("5");
        when(view.articleList.getSelectedIndex()).thenReturn(0);

        // Initialize the controller
        controller = new CoursesController(model, view);
    }

    @Test
    void testAjouterArticle_ValidInput() {
        // Act
        controller.ajouterArticle();

        // Assert
        verify(model).ajouter(any(Article.class)); // Verify that the model's ajouter method was called
        verify(view.listModel).addElement("Test Article - 5"); // Verify that the view was updated
    }

    @Test
    void testAjouterArticle_InvalidQuantity() {
        // Arrange
        when(view.quantiteField.getText()).thenReturn("invalid");

        // Act
        controller.ajouterArticle();

        // Assert
        verify(model, never()).ajouter(any(Article.class)); // Ensure the model was not called
        verify(view).showMessageDialog("Quantité invalide !"); // Verify the error message
    }

    @Test
    void testAjouterArticle_InvalidNameOrQuantity() {
        // Arrange
        when(view.nomField.getText()).thenReturn(""); // Empty name
        when(view.quantiteField.getText()).thenReturn("0"); // Quantity <= 0

        // Act
        controller.ajouterArticle();

        // Assert
        verify(model, never()).ajouter(any(Article.class)); // Ensure the model was not called
        verify(view).showMessageDialog("Nom invalide ou quantité <= 0 !"); // Verify the error message
    }

    @Test
    void testModifierArticle_ValidInput() {
        // Arrange
        when(view.nomField.getText()).thenReturn("Updated Article");
        when(view.quantiteField.getText()).thenReturn("10");

        // Act
        controller.modifierArticle();

        // Assert
        verify(model).modifier(0, "Updated Article", 10); // Verify that the model's modifier method was called
        verify(view.listModel).set(0, "Updated Article - 10"); // Verify that the view was updated
    }

    @Test
    void testModifierArticle_InvalidQuantity() {
        // Arrange
        when(view.quantiteField.getText()).thenReturn("invalid");

        // Act
        controller.modifierArticle();

        // Assert
        verify(model, never()).modifier(anyInt(), anyString(), anyInt()); // Ensure the model was not called
        verify(view).showMessageDialog("Quantité invalide !"); // Verify the error message
    }

    @Test
    void testSupprimerArticle_ValidIndex() {
        // Act
        controller.supprimerArticle();

        // Assert
        verify(model).supprimer(0); // Verify that the model's supprimer method was called
        verify(view.listModel).remove(0); // Verify that the view was updated
    }

    @Test
    void testSupprimerArticle_InvalidIndex() {
        // Arrange
        when(view.articleList.getSelectedIndex()).thenReturn(-1); // No selection

        // Act
        controller.supprimerArticle();

        // Assert
        verify(model, never()).supprimer(anyInt()); // Ensure the model was not called
    }
}