package com.example.Control;

import com.example.Model.Perspective;

public class CommandeCopyPaste implements Commande{
    private Perspective source, destination;

    public CommandeCopyPaste(Perspective source, Perspective destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void executer() {
        //TODO
    }

    @Override
    public void annuler() {
        //TODO
    }
}
