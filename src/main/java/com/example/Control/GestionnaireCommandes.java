package com.example.Control;

import com.example.View.View;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance = null;
    private Map<View, Stack<Commande>> pileVue = new HashMap<>();

    private GestionnaireCommandes(){}

    public static GestionnaireCommandes getInstance() {
        if (instance == null){
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    public void executerCommande(Commande commande, View view){
        commande.executer();
        pileVue.putIfAbsent(view, new Stack<>());
        pileVue.get(view).push(commande);
    }

    public void undo(View view){
        Stack<Commande> commandes = pileVue.get(view);
        if(commandes != null && !commandes.isEmpty()){
            Commande last = commandes.pop();
            last.annuler();
        }

    }
}
