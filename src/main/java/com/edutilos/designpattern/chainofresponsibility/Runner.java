package com.edutilos.designpattern.chainofresponsibility;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        CustomLogger lg1, lg2, lg3 ;
        lg1 = new ConsoleLogger();
        lg2 = new FileLogger();
        lg3 = new EmailLogger();
        lg1.setNextLogger(lg2);
        lg2.setNextLogger(lg3);
        lg1.logMessage("Hello World");
    }
}
