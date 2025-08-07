/**
 * Laboratoire 5
 * @author : Maxim Tchapalo, Francis Beaulieu-Ménard, Vladyslav Lukyanov
 * @cours : LOG121 Conception Orientée Objet
 * Classe Observateur abstraite que fournit 2 methodes de base
 */

package com.example.Model;

import java.util.ArrayList;
import java.util.List;

import com.example.View.Observer;

public abstract class Observable {
    public List<Observer> observerList = new ArrayList<>();
    
    public void notifyObservers(){
        observerList.forEach((Observer observer) -> {
            observer.update();
        });
    }
    
    public void addObserver(Observer observer){
        observerList.add(observer);
    }
} 