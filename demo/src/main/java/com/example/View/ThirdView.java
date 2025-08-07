/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 */

package com.example.View;

import com.example.Model.ImageModel;
import com.example.Model.Perspective;

import javafx.scene.image.ImageView;

public class ThirdView implements View, Observer {
    private ImageView imageView;
    private ImageModel imageModel;
    private Perspective perspective;

    public ThirdView(ImageView imageView, ImageModel imageModel, Perspective perspective) {
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
                imageView.setScaleX(perspective.getZoom());
                imageView.setScaleY(perspective.getZoom());
                imageView.setTranslateX(perspective.getOffsetX());
                imageView.setTranslateY(perspective.getOffsetY());
                imageView.getParent().requestLayout();
            });
        }
    }
} 