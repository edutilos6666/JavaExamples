package com.edutilos.designpattern.interpreter.example1;


public class InterpreterContext {
   public String toBinary(int number) {
       return Integer.toBinaryString(number);
   }

   public String toHex(int number) {
       return Integer.toHexString(number);
   }
}
