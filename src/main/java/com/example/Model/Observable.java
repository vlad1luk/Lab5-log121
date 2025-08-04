package com.example.Model;

import com.example.View.Observer;

import java.util.ArrayList;
import java.util.List;

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
