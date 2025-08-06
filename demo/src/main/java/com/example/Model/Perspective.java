package com.example.Model;

public class Perspective extends Observable {
    private double zoom = 1.0;  
    private int offsetX, offsetY;

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = Math.max(0.1, Math.min(3.0, zoom));
        notifyObservers();
    }

    public void setOffset(int offsetX, int offsetY) {
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        notifyObservers();
    }

    public int getOffsetX() {
        return offsetX;
    }

    public int getOffsetY() {
        return offsetY;
    }
} 