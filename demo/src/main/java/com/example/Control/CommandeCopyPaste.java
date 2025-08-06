package com.example.Control;

import com.example.Model.Perspective;

public class CommandeCopyPaste implements Commande {
    private Perspective source;
    private Perspective destination;
    private double ancienZoom;
    private int ancienOffsetX, ancienOffsetY;

    public CommandeCopyPaste(Perspective source, Perspective destination) {
        this.source = source;
        this.destination = destination;
        this.ancienZoom = destination.getZoom();
        this.ancienOffsetX = destination.getOffsetX();
        this.ancienOffsetY = destination.getOffsetY();
    }

    @Override
    public void executer() {
        destination.setZoom(source.getZoom());
        destination.setOffset(source.getOffsetX(), source.getOffsetY());
    }

    @Override
    public void annuler() {
        destination.setZoom(ancienZoom);
        destination.setOffset(ancienOffsetX, ancienOffsetY);
    }
} 