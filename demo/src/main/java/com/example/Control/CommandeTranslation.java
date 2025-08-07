/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 */

package com.example.Control;

import com.example.Model.Perspective;

public class CommandeTranslation implements Commande {
    private Perspective perspective;
    private int ancienOffsetX, ancienOffsetY;
    private int nouveauOffsetX, nouveauOffsetY;

    public CommandeTranslation(Perspective perspective, int nouveauOffsetX, int nouveauOffsetY) {
        this.perspective = perspective;
        this.nouveauOffsetX = nouveauOffsetX;
        this.nouveauOffsetY = nouveauOffsetY;
        this.ancienOffsetX = perspective.getOffsetX();
        this.ancienOffsetY = perspective.getOffsetY();
    }

    @Override
    public void executer() {
        perspective.setOffset(nouveauOffsetX, nouveauOffsetY);
    }

    @Override
    public void annuler() { 
        perspective.setOffset(ancienOffsetX, ancienOffsetY);
    }
} 