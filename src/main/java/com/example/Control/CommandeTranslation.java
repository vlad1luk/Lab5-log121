package com.example.Control;

import com.example.Model.Perspective;

public class CommandeTranslation implements Commande{
    private Perspective perspective;
    private int oldX, oldY, newX, newY;

    public CommandeTranslation(Perspective perspective, int newX, int newY) {
        this.perspective = perspective;
        this.oldX = perspective.getOffsetX();
        this.oldY = perspective.getOffsetY();
        this.newX = newX;
        this.newY = newY;
    }

    public void setPerspective(Perspective perspective) {
        this.perspective = perspective;
    }

    public void setOldX(int oldX) {
        this.oldX = oldX;
    }

    public void setOldY(int oldY) {
        this.oldY = oldY;
    }

    public void setNewX(int newX) {
        this.newX = newX;
    }

    public void setNewY(int newY) {
        this.newY = newY;
    }

    @Override
    public void executer() {
        perspective.setOffset(newX,newY);
    }

    @Override
    public void annuler() {
        perspective.setOffset(oldX,oldY);
    }
}
