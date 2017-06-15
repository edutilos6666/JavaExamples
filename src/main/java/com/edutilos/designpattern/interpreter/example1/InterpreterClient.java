package com.edutilos.designpattern.interpreter.example1;

/**
 * Created by edutilos on 15.06.17.
 */
public class InterpreterClient {
    private Expression expression ;
    private InterpreterContext ctx ;

    public InterpreterClient() {
        ctx = new InterpreterContext();
    }

    public String interpret(String str) throws Exception {


      Integer number = Integer.parseInt(str.substring(0, str.indexOf(" ")));
        if(str.contains("Binary")) {
            expression = new ToBinaryExpression(number);
        } else if(str.contains("Hex")) {
            expression = new ToHexExpression(number);
        } else {
            expression = null;
        }

        if(expression == null) {
            throw new Exception(String.format("Can not interpret %s", str));

        }
      return expression.evaluate(ctx);
   }
}
