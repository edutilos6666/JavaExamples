package com.edutilos.designpattern.state;

/**
 * Created by edutilos on 15.06.17.
 */
public class Context {
    private State state ;
    public Context() {
        this.state = null ;
    }
    public void setState(State state) {
        this.state = state ;
    }

    public State getState() {
        return this.state ;
    }
}
