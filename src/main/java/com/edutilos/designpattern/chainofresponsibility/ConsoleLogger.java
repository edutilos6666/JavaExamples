package com.edutilos.designpattern.chainofresponsibility;

/**
 * Created by edutilos on 15.06.17.
 */
public class ConsoleLogger implements CustomLogger {

    private CustomLogger nextLogger ;
    @Override
    public void logMessage(String msg) {
        System.out.println(String.format("<<Console>>: %s", msg));
        if(nextLogger != null)
            nextLogger.logMessage(msg);
    }

    @Override
    public void setNextLogger(CustomLogger nextLogger) {
       this.nextLogger = nextLogger;
    }

    @Override
    public CustomLogger getNextLogger() {
        return nextLogger;
    }
}
