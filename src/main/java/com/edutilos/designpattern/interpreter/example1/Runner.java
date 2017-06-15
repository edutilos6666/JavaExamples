package com.edutilos.designpattern.interpreter.example1;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        InterpreterClient client = new InterpreterClient();
        String [] expressions = {
                "128 In Binary",
                "128 In Hex",
                "128 In Octal"
        };

        try {
            for(String expression: expressions) {
                System.out.println(String.format("%s => %s", expression, client.interpret(expression)));
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
