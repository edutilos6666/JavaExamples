package com.edutilos.designpattern.template;

/**
 * Created by edutilos on 16.06.17.
 */
public abstract class Software {
  public abstract void start();
  public abstract void use();
  public abstract void close();

  public void all() {
      start();
      use();
      close();
  }
}
