/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 */

package com.example.Control;

import java.util.Stack;

public class GestionnaireCommandes {
    private static GestionnaireCommandes instance;
    private Stack<Commande> historiqueCommandes;
    private Stack<Commande> historiqueAnnulees;

    private GestionnaireCommandes() {
        historiqueCommandes = new Stack<>();
        historiqueAnnulees = new Stack<>();
    }

    public static GestionnaireCommandes getInstance() {
        if (instance == null) {
            instance = new GestionnaireCommandes();
        }
        return instance;
    }

    public void executerCommande(Commande commande) {
        commande.executer();
        historiqueCommandes.push(commande);
        historiqueAnnulees.clear(); // Vider l'historique des annulations
    }

    public void annuler() {
        if (!historiqueCommandes.isEmpty()) {
            Commande commande = historiqueCommandes.pop();
            commande.annuler();
            historiqueAnnulees.push(commande);
        }
    }

    public void refaire() {
        if (!historiqueAnnulees.isEmpty()) {
            Commande commande = historiqueAnnulees.pop();
            commande.executer();
            historiqueCommandes.push(commande);
        }
    }

    public boolean peutAnnuler() {
        return !historiqueCommandes.isEmpty();
    }

    public boolean peutRefaire() {
        return !historiqueAnnulees.isEmpty();
    }
} 