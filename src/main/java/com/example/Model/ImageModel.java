package com.example.Model;

import com.example.View.Observer;

import java.awt.image.BufferedImage;

public class ImageModel extends Observable {
    private BufferedImage image;

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
        notifyObservers();
    }
}
