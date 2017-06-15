package com.edutilos.designpattern.interpreter.example2;

/**
 * Created by edutilos on 15.06.17.
 */
public class NotExpression implements Expression {
    private Expression exp ;
    public NotExpression(Expression exp) {
        this.exp = exp ;
    }
    @Override
    public boolean evaluate(String ctx) {
        return !exp.evaluate(ctx);
    }
}
