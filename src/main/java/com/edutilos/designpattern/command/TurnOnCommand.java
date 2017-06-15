package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class TurnOnCommand implements  Command {
    private Car car ;
    public TurnOnCommand(Car car) {
        this.car = car ;
    }

    @Override
    public void execute() {
      car.turnOn();
    }
}
