package com.edutilos.designpattern.observer;

/**
 * Created by edutilos on 15.06.17.
 */
public interface CustomObserver {
   void subscribe(ObservablePerson p);
   void unsubscribe(ObservablePerson p);
   void update();
}
