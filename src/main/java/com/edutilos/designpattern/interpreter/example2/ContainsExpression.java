package com.edutilos.designpattern.interpreter.example2;

/**
 * Created by edutilos on 15.06.17.
 */
public class ContainsExpression implements Expression {
    private String data;
    public ContainsExpression(String data) {
        this.data = data ;
    }
    @Override
    public boolean evaluate(String ctx) {
        return ctx.contains(data);
    }
}
