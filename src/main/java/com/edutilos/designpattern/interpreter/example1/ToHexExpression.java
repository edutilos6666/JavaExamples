package com.edutilos.designpattern.interpreter.example1;

/**
 * Created by edutilos on 15.06.17.
 */
public class ToHexExpression implements  Expression {
    private int number;
    public ToHexExpression(int number) {
        this.number = number ;
    }
    @Override
    public String evaluate(InterpreterContext ctx) {
        return ctx.toHex(number);
    }
}
