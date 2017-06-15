package com.edutilos.designpattern.chainofresponsibility;

/**
 * Created by edutilos on 15.06.17.
 */
public interface CustomLogger {
  void logMessage(String msg);
  void setNextLogger(CustomLogger nextLogger);
  CustomLogger getNextLogger();
}
