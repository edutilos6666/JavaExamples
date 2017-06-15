package com.edutilos.designpattern.interpreter.example1;

/**
 * Created by edutilos on 15.06.17.
 */
public class ToBinaryExpression implements  Expression {
    private int number;
    public ToBinaryExpression(int number) {
        this.number = number;
    }
    @Override
    public String evaluate(InterpreterContext ctx) {
        return ctx.toBinary(number);
    }
}
