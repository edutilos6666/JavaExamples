package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class StopCommand implements  Command {
    private Car car ;
    public StopCommand(Car car) {
        this.car = car ;
    }

    @Override
    public void execute() {
      car.stop();
    }
}
