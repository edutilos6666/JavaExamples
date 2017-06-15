package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class TurnRightCommand implements  Command {
    private Car car ;
    public TurnRightCommand(Car car) {
        this.car = car ;
    }

    @Override
    public void execute() {
      car.turnRight();
    }
}
