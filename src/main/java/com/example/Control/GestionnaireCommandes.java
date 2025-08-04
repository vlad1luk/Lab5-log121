package com.example.Control;

import com.example.View.View;

import java.util.Map;
import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance = null;
    private Map<View, Stack<Commande>> pileVue;

    private GestionnaireCommandes(){}

    public static GestionnaireCommandes getInstance() {
        if (instance == null){
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    public void executerCommande(Commande commande, View view){
        //TODO
    }

    public void defaire(View vue){
        //TODO
    }
}
