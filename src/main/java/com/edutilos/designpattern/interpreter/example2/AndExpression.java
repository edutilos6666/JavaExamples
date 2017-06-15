package com.edutilos.designpattern.interpreter.example2;

/**
 * Created by edutilos on 15.06.17.
 */
public class AndExpression implements Expression {
    private Expression exp1, exp2 ;
    public AndExpression(Expression exp1, Expression exp2) {
        this.exp1 = exp1 ;
        this.exp2 = exp2;
    }

    @Override
    public boolean evaluate(String ctx) {
        return exp1.evaluate(ctx) && exp2.evaluate(ctx);
    }
}
