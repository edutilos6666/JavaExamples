package com.edutilos.designpattern.state;

/**
 * Created by edutilos on 16.06.17.
 */
public class PlayState implements  State  {
    @Override
    public void doAction(Context ctx) {
        System.out.println("In PlayState");
        ctx.setState(this);
    }
}
