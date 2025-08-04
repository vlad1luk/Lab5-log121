package com.example.Control;

import com.example.Model.Perspective;

public class CommandeTranslation implements Commande{
    private Perspective perspective;
    private int oldX, oldY, newX, newY;

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
        oldX = perspective.getOffsetX();
        oldY = perspective.getOffsetY();
        perspective.setOffsetX(newX);
        perspective.setOffsetY(newY);
    }

    @Override
    public void annuler() {
        perspective.setOffsetX(oldX);
        perspective.setOffsetY(oldY);
    }
}
