package com.example.Control;

import com.example.Model.Perspective;

public class CommandeZoom implements Commande {
    private Perspective perspective;
    private double ancienZoom;
    private double nouveauZoom;

    public CommandeZoom(Perspective perspective, double nouveauZoom) {
        this.perspective = perspective;
        this.nouveauZoom = nouveauZoom;
        this.ancienZoom = perspective.getZoom();
    }

    @Override
    public void executer() {
        perspective.setZoom(nouveauZoom);
    }

    @Override
    public void annuler() {
        perspective.setZoom(ancienZoom);
    }
} 