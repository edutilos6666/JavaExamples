package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class TurnLeftCommand implements  Command {
    private Car car ;
    public TurnLeftCommand(Car car) {
        this.car = car ;
    }

    @Override
    public void execute() {
      car.turnLeft();
    }
}
