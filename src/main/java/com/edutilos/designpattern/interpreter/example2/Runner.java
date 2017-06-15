package com.edutilos.designpattern.interpreter.example2;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        Expression insertExp, updateExp, selectExp , deleteExp ;
        insertExp = new ContainsExpression("insert");
        updateExp =new ContainsExpression("update");
        selectExp = new ContainsExpression("select");
        deleteExp = new ContainsExpression("delete");

        String str1 = "insert, update",
                str2 = "select, delete";

        System.out.println(insertExp.evaluate(str1));
        System.out.println(insertExp.evaluate(str2));
        System.out.println();

        System.out.println(selectExp.evaluate(str1));
        System.out.println(selectExp.evaluate(str2));
        System.out.println();

        Expression selectAndUpdate, selectAndDelete ;
        selectAndUpdate = new AndExpression(selectExp, updateExp);
        selectAndDelete = new AndExpression(selectExp, deleteExp);
        System.out.println(selectAndUpdate.evaluate(str1));
        System.out.println(selectAndUpdate.evaluate(str2));
        System.out.println(selectAndDelete.evaluate(str1));
        System.out.println(selectAndDelete.evaluate(str2));

    }
}
