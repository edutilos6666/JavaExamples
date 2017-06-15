package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class TurnOffCommand implements  Command {
    private Car car ;
    public TurnOffCommand(Car car) {
        this.car = car ;
    }

    @Override
    public void execute() {
      car.turnOff();
    }
}
