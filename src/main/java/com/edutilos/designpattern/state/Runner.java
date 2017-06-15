package com.edutilos.designpattern.state;

/**
 * Created by edutilos on 16.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        State s1 , s2 , s3 ;
        Context ctx = new Context();
        s1 = new StartState();
        s2 = new PlayState();
        s3 = new StopState();
        s1.doAction(ctx);
        s2.doAction(ctx);
        s3.doAction(ctx);
    }
}
