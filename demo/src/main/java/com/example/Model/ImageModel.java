/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 */

package com.example.Model;

import java.io.Serializable;

import javafx.scene.image.Image;

public class ImageModel extends Observable implements Serializable {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
        notifyObservers();
    }
} 