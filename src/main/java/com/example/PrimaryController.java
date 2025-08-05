// Maxim Tchapalo, Controller pour la page principale
package com.example;

import java.io.File;
import java.util.Optional;

import com.example.Control.Commande;
import com.example.Control.GestionnaireCommandes;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.StageStyle;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar;
import javafx.stage.Stage;




public class PrimaryController {
    //Definition de vars
    @FXML
    ImageView imageView;
    @FXML
    ImageView imagePerspective1;
    @FXML
    ImageView imagePerspective2;

    
    Stage stage;
    private boolean isPositionActive = true;
    private boolean isZoomActive = true;

    GestionnaireCommandes instance = GestionnaireCommandes.getInstance();
    Commande commande;
    // Set les combo box et ajouter des listeners
    public void initialize() {
        imageView.setImage(null);
    }


    //Fichier
    public void savePerspective() {
        // Logique pour sauvegarder la perspective
    }
    public void loadPerspective() {
        // Logique pour charger la perspective
    }
    public void loadImage() {
        if(stage == null) {
            stage = (Stage) imageView.getScene().getWindow();
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Sélectionnez une image");

        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
            "Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.webp");
        fileChooser.getExtensionFilters().add(imageFilter);

        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            System.out.println("Selected file: " + selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image); // if you have an ImageView
        }
    }
    public void quit() {
        System.exit(0);
    }

    //Edition
    public void undo() {
        // Logique pour annuler la dernière action
        //instance.undo();//faire dequoi avec la view et la commande
    }
    public void redo() {
        // Logique pour refaire la dernière action annulée
    }
    
    //Presse-Papier
    public void chooseStrategy() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Choisir stratégie");
        alert.initStyle(StageStyle.UTILITY); // Makes it small
        alert.getDialogPane().setPrefWidth(250);
        
        CheckBox checkBoxPosition = new CheckBox("Position");
        checkBoxPosition.setSelected(isPositionActive);
        CheckBox checkBoxZoom = new CheckBox("Niveau de zoom");
        checkBoxZoom.setSelected(isZoomActive);
        HBox content = new HBox(10, checkBoxPosition, checkBoxZoom);
        alert.getDialogPane().setContent(content);

        ButtonType confirmButton = new ButtonType("Confirmer", ButtonBar.ButtonData.OK_DONE);
        alert.getButtonTypes().setAll(confirmButton, ButtonType.CANCEL);

        Optional<ButtonType> result = alert.showAndWait();

        // Handle confirm
        if (result.isPresent() && result.get() == confirmButton) {
            isPositionActive = checkBoxPosition.isSelected();
            isZoomActive = checkBoxZoom.isSelected();
        }
        
    }



}
