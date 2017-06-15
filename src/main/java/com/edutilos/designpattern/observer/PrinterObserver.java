package com.edutilos.designpattern.observer;

/**
 * Created by edutilos on 15.06.17.
 */
public class PrinterObserver implements  CustomObserver {

    private ObservablePerson p;

    @Override
    public void subscribe(ObservablePerson p) {
      this.p = p ;
      this.p.registerObserver(this);
    }

    @Override
    public void unsubscribe(ObservablePerson p) {
        p.unregisterObserver(this);
    }

    @Override
    public void update() {
        System.out.println(String.format("<<Printer>>: %s", p.toString()));
    }
}
