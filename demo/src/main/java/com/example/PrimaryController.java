package com.example;

import java.io.File;
import java.util.Optional;

import com.example.Control.CommandeCopyPaste;
import com.example.Control.CommandeTranslation;
import com.example.Control.CommandeZoom;
import com.example.Control.GestionnaireCommandes;
import com.example.Model.ImageModel;
import com.example.Model.Perspective;
import com.example.View.Observer;
import com.example.View.PrimaryView;
import com.example.View.SecondaryView;
import com.example.View.ThirdView;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrimaryController {
    @FXML
    ImageView imageView;
    @FXML
    ImageView imagePerspective1;
    @FXML
    ImageView imagePerspective2;

    private ImageModel imageModel;
    private Perspective perspective1;
    private Perspective perspective2;
    
    private PrimaryView primaryView;
    private SecondaryView secondaryView;
    private ThirdView thirdView;
    
    private GestionnaireCommandes gestionnaireCommandes;
    
    private Perspective perspectiveCopiee;
    
    Stage stage;
    private boolean isPositionActive = true;
    private boolean isZoomActive = true;
    
    public void initialize() {
        imageView.setImage(null);
        
        imageModel = new ImageModel();
        perspective1 = new Perspective();
        perspective2 = new Perspective();
        
        imageModel.addObserver(new Observer() {
            @Override
            public void update() {
                if (imageModel.getImage() != null) {
                    imageView.setImage(imageModel.getImage());
                }
            }
        });
        
        imageModel.addObserver(new Observer() {
            @Override
            public void update() {
                if (imageModel.getImage() != null) {
                    imagePerspective1.setImage(imageModel.getImage());
                }
            }
        });
        
        imageModel.addObserver(new Observer() {
            @Override
            public void update() {
                if (imageModel.getImage() != null) {
                    imagePerspective2.setImage(imageModel.getImage());
                }
            }
        });
        
        perspective1.addObserver(new Observer() {
            @Override
            public void update() {
                double containerWidth = ((javafx.scene.layout.Region)imagePerspective1.getParent()).getWidth();
                double containerHeight = ((javafx.scene.layout.Region)imagePerspective1.getParent()).getHeight();
                
                imagePerspective1.setFitWidth(containerWidth);
                imagePerspective1.setFitHeight(containerHeight);
                
                imagePerspective1.setScaleX(perspective1.getZoom());
                imagePerspective1.setScaleY(perspective1.getZoom());
                imagePerspective1.setTranslateX(perspective1.getOffsetX());
                imagePerspective1.setTranslateY(perspective1.getOffsetY());
                
                if(imagePerspective1.getClip() instanceof javafx.scene.shape.Rectangle) {
                    javafx.scene.shape.Rectangle clip = (javafx.scene.shape.Rectangle) imagePerspective1.getClip();
                    clip.setWidth(containerWidth);
                    clip.setHeight(containerHeight);
                }
            }
        });
        
        perspective2.addObserver(new Observer() {
            @Override
            public void update() {
                double containerWidth = ((javafx.scene.layout.Region)imagePerspective2.getParent()).getWidth();
                double containerHeight = ((javafx.scene.layout.Region)imagePerspective2.getParent()).getHeight();                
                imagePerspective2.setFitWidth(containerWidth);
                imagePerspective2.setFitHeight(containerHeight);
                
                imagePerspective2.setScaleX(perspective2.getZoom());
                imagePerspective2.setScaleY(perspective2.getZoom());
                imagePerspective2.setTranslateX(perspective2.getOffsetX());
                imagePerspective2.setTranslateY(perspective2.getOffsetY());
                
                if (imagePerspective2.getClip() instanceof javafx.scene.shape.Rectangle) {
                    javafx.scene.shape.Rectangle clip = (javafx.scene.shape.Rectangle) imagePerspective2.getClip();
                    clip.setWidth(containerWidth);
                    clip.setHeight(containerHeight);
                }
            }
        });
        
        primaryView = new PrimaryView(imageView, imageModel, perspective1);
        secondaryView = new SecondaryView(imagePerspective1, imageModel, perspective1);
        thirdView = new ThirdView(imagePerspective2, imageModel, perspective2);
        
        gestionnaireCommandes = GestionnaireCommandes.getInstance();
    }

    public void savePerspective() {
    }
    
    public void loadPerspective() {
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
            System.out.println("Fichier sélectionné: " + selectedFile.getAbsolutePath());
            Image image = new Image(selectedFile.toURI().toString());
            imageModel.setImage(image);
        }
    }
    
    public void quit() {
        System.exit(0);
    }

    public void undo() {
        if (gestionnaireCommandes.peutAnnuler()) {
            gestionnaireCommandes.annuler();
        }
    }
    
    public void redo() {
        if (gestionnaireCommandes.peutRefaire()) {
            gestionnaireCommandes.refaire();
        }
    }
    
    public void zoomIn1() {
        double newZoom = perspective1.getZoom() * 1.1;
        if (newZoom <= 3.0) {
            CommandeZoom commande = new CommandeZoom(perspective1, newZoom);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
    
    public void zoomOut1() {
        double newZoom = perspective1.getZoom() * 0.9;
        if (newZoom >= 0.1) {
            CommandeZoom commande = new CommandeZoom(perspective1, newZoom);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
    
    public void translateUp1() {
        CommandeTranslation commande = new CommandeTranslation(perspective1, 
            perspective1.getOffsetX(), perspective1.getOffsetY() - 10);
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateDown1() {
        CommandeTranslation commande = new CommandeTranslation(perspective1, 
            perspective1.getOffsetX(), perspective1.getOffsetY() + 10);
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateLeft1() {
        CommandeTranslation commande = new CommandeTranslation(perspective1, 
            perspective1.getOffsetX() - 10, perspective1.getOffsetY());
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateRight1() {
        CommandeTranslation commande = new CommandeTranslation(perspective1, 
            perspective1.getOffsetX() + 10, perspective1.getOffsetY());
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void zoomIn2() {
        double newZoom = perspective2.getZoom() * 1.1;
        if (newZoom <= 3.0) {
            CommandeZoom commande = new CommandeZoom(perspective2, newZoom);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
    
    public void zoomOut2() {
        double newZoom = perspective2.getZoom() * 0.9;
        if (newZoom >= 0.1) {
            CommandeZoom commande = new CommandeZoom(perspective2, newZoom);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
    
    public void translateUp2() {
        CommandeTranslation commande = new CommandeTranslation(perspective2, 
            perspective2.getOffsetX(), perspective2.getOffsetY() - 10);
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateDown2() {
        CommandeTranslation commande = new CommandeTranslation(perspective2, 
            perspective2.getOffsetX(), perspective2.getOffsetY() + 10);
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateLeft2() {
        CommandeTranslation commande = new CommandeTranslation(perspective2, 
            perspective2.getOffsetX() - 10, perspective2.getOffsetY());
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void translateRight2() {
        CommandeTranslation commande = new CommandeTranslation(perspective2, 
            perspective2.getOffsetX() + 10, perspective2.getOffsetY());
        gestionnaireCommandes.executerCommande(commande);
    }
    
    public void chooseStrategy() {
        Alert alert = new Alert(Alert.AlertType.NONE);
        alert.setTitle("Choisir stratégie");
        alert.initStyle(StageStyle.UTILITY);
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

        if (result.isPresent() && result.get() == confirmButton) {
            isPositionActive = checkBoxPosition.isSelected();
            isZoomActive = checkBoxZoom.isSelected();
        }
    }
    
    public void copyPerspective1() {
        perspectiveCopiee = perspective1;
        System.out.println("Perspective 1 copiée");
    }
    
    public void pasteToPerspective1() {
        if (perspectiveCopiee != null) {
            CommandeCopyPaste commande = new CommandeCopyPaste(perspectiveCopiee, perspective1);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
    
    public void copyPerspective2() {
        perspectiveCopiee = perspective2;
        System.out.println("Perspective 2 copiée");
    }
    
    public void pasteToPerspective2() {
        if (perspectiveCopiee != null) {
            CommandeCopyPaste commande = new CommandeCopyPaste(perspectiveCopiee, perspective2);
            gestionnaireCommandes.executerCommande(commande);
        }
    }
}
