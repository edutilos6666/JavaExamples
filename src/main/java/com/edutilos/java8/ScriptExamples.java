package com.edutilos.java8;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

/**
 * Created by edutilos on 16.06.17.
 */
public class ScriptExamples {
    public static void main(String[] args) {
        test1();
    }



    private static void test1() {
        try {
            ScriptEngineManager sem = new ScriptEngineManager();
            ScriptEngine js  = sem.getEngineByName("JavaScript");
            js.eval("print('js: Hello World!')");
            ScriptEngine groovy = sem.getEngineByName("Groovy");
            groovy.eval("println('groovy: Hello World!')");
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
