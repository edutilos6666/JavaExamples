package com.edutilos.designpattern.command;

/**
 * Created by edutilos on 15.06.17.
 */
public class Car {
    private String name;

    public Car(String name) {
        this.name = name;
    }

   public void turnOn() {
       System.out.println(String.format("%s was turned on.", name));
   }

   public void turnOff() {
       System.out.println(String.format("%s was turned off.", name));
   }

   public void turnLeft() {
       System.out.println(String.format("%s was turned to left.", name));
   }

   public void turnRight() {
       System.out.println(String.format("%s was turned to right." , name));
   }

   public void increaseSpeed(double speed) {
       System.out.println(String.format("The speed of %s was increased in %.0f", name, speed));
   }

   public void decreaseSpeed(double speed) {
       System.out.println(String.format("The speed of %s was decreased in %.0f", name, speed));
   }

   public void stop() {
       System.out.println(String.format("%s was stopped.", name));
   }
}
