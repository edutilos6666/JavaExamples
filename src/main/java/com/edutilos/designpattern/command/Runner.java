package com.edutilos.designpattern.command;

import java.util.Arrays;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        Command turnOn, turnOff ,
                turnLeft , turnRight ,
                increaseSpeed, decreaseSpeed,
                stop;
        Car car = new Car("BMW");
        turnOn = new TurnOnCommand(car);
        turnOff = new TurnOffCommand(car);
        turnLeft = new TurnLeftCommand(car);
        turnRight = new TurnRightCommand(car);
        increaseSpeed = new IncreaseSpeedCommand(car, 200);
        decreaseSpeed = new DecreaseSpeedCommand(car, 100);
        stop  = new StopCommand(car);
       CarCommands carCommands = new CarCommands();
       carCommands.registerCommands(Arrays.asList(turnOn ,
               turnLeft, turnRight ,
               increaseSpeed, decreaseSpeed, stop, turnOff));

       carCommands.batchExecuteCommands();
     }
}
