package com.example.Control;

import com.example.Model.Perspective;

public class CommandeCopyPaste implements Commande{
    private Perspective source, destination;
    //pour le undo
    private int oldOffsetX, oldOffsetY;
    private double oldZoom;

    public CommandeCopyPaste(Perspective source, Perspective destination) {
        this.source = source;
        this.destination = destination;

        oldZoom = destination.getZoom();
        oldOffsetX = destination.getOffsetX();
        oldOffsetY = destination.getOffsetY();
    }

    @Override
    public void executer() {
        destination.setOffset(source.getOffsetX(), source.getOffsetY());
        destination.setZoom(source.getZoom());
    }

    @Override
    public void annuler() {
        destination.setOffset(oldOffsetX,oldOffsetY);
        destination.setZoom(oldZoom);
    }
}
