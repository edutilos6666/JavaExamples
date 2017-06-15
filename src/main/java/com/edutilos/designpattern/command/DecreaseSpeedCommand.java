package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class DecreaseSpeedCommand implements  Command {
    private Car car ;
    private double speed ;
    public DecreaseSpeedCommand(Car car, double speed) {
        this.car = car ;
        this.speed = speed ;
    }

    @Override
    public void execute() {
      car.decreaseSpeed(speed);
    }
}
