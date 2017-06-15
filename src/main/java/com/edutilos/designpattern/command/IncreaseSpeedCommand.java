package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class IncreaseSpeedCommand implements  Command {
    private Car car ;
    private double speed ;
    public IncreaseSpeedCommand(Car car, double speed) {
        this.car = car ;
        this.speed = speed ;
    }

    @Override
    public void execute() {
      car.increaseSpeed(speed);
    }
}
