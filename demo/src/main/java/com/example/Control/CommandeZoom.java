/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 */

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

    
    // execute le zoom, mais avant verifie la limite
    @Override
    public void executer() {
        if(nouveauZoom <= MAX_ZOOM)
            perspective.setZoom(nouveauZoom);
    }

    
    @Override
    public void annuler() {
        perspective.setZoom(ancienZoom);
    }
} 