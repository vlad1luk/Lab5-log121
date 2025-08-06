package com.example.View;

import com.example.Model.ImageModel;
import com.example.Model.Perspective;

import javafx.scene.image.ImageView;

public class PrimaryView implements View, Observer {
    private ImageView imageView;
    private ImageModel imageModel;
    private Perspective perspective;

    public PrimaryView(ImageView imageView, ImageModel imageModel, Perspective perspective) {
        this.imageView = imageView;
        this.imageModel = imageModel;
        this.perspective = perspective;
        
    }

    @Override
    public void afficher() {
        update();
    }

    @Override
    public void update() {
        if (imageModel.getImage() != null) {
            javafx.application.Platform.runLater(() -> {
                imageView.setImage(imageModel.getImage());
                
                // Appliquer les transformations de perspective
                imageView.setScaleX(perspective.getZoom());
                imageView.setScaleY(perspective.getZoom());
                imageView.setTranslateX(perspective.getOffsetX());
                imageView.setTranslateY(perspective.getOffsetY());
                
                // Forcer le rafraîchissement
                imageView.getParent().requestLayout();
            });
        }
    }
} 