package com.example.Control;

import com.example.Model.Perspective;

public class CommandeZoom implements Commande{
    private Perspective perspective;
    private double oldZoom, newZoom;

    public CommandeZoom(Perspective perspective, double newZoom) {
        this.perspective = perspective;
        this.oldZoom = perspective.getZoom();
        this.newZoom = newZoom;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    public void setOldZoom(double oldZoom) {
        this.oldZoom = oldZoom;
    }

    public void setNewZoom(double newZoom) {
        this.newZoom = newZoom;
    }

    @Override
    public void executer() {
        perspective.setZoom(newZoom);
    }

    @Override
    public void annuler() {
        perspective.setZoom(oldZoom);
    }

}
