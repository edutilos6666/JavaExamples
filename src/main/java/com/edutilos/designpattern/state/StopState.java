package com.edutilos.designpattern.state;

/**
 * Created by edutilos on 16.06.17.
 */
public class StopState implements State {
    @Override
    public void doAction(Context ctx) {
        System.out.println("In StopState");
        ctx.setState(this);
    }
}
