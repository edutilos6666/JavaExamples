package com.edutilos.designpattern.facade;

/**
 * Created by edutilos on 15.06.17.
 */
public class CompilationFacade {
    private LexicalAnalyzer lexicalAnalyzer;
    private SyntaxAnalyzer syntaxAnalyzer;
    private SemanticAnalyzer semanticAnalyzer;
    private IntermediateCodeGenerator intermediateCodeGenerator;
    private MachineIndependentCodeOptimizer machineIndependentCodeOptimizer;
    private CodeGenerator codeGenerator;
    private MachineDependentCodeOptimizer machineDependentCodeOptimizer;

    public CompilationFacade() {
        lexicalAnalyzer = new LexicalAnalyzer();
        syntaxAnalyzer = new SyntaxAnalyzer();
        semanticAnalyzer = new SemanticAnalyzer();
        intermediateCodeGenerator = new IntermediateCodeGenerator();
        machineIndependentCodeOptimizer = new MachineIndependentCodeOptimizer();
        codeGenerator = new CodeGenerator();
        machineDependentCodeOptimizer = new MachineDependentCodeOptimizer();
    }

    public void compile() {
        System.out.println("Compilation started...");
        lexicalAnalyzer.execute();
        syntaxAnalyzer.execute();
        semanticAnalyzer.execute();
        intermediateCodeGenerator.execute();
        machineIndependentCodeOptimizer.execute();
        codeGenerator.execute();
        machineDependentCodeOptimizer.execute();
        System.out.println("Compilated was completed successfully.");
  }
}
