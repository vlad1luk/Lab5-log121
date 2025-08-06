package com.example.Control;

import com.example.Model.Perspective;

public class CommandeZoom implements Commande {
    private Perspective perspective;
    private double ancienZoom;
    private double nouveauZoom;
    final double MAX_ZOOM = 1.0252718826976899;

    public CommandeZoom(Perspective perspective, double nouveauZoom) {
        this.perspective = perspective;
        this.nouveauZoom = nouveauZoom;
        this.ancienZoom = perspective.getZoom();
    }

    @Override
    public void executer() {
        System.out.println(nouveauZoom);
        if(nouveauZoom <= MAX_ZOOM)
            perspective.setZoom(nouveauZoom);
    }

    @Override
    public void annuler() {
        perspective.setZoom(ancienZoom);
    }
} 