package com.edutilos.designpattern.composite;

import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
       Employee ceo = new Employee("foo", "CEO");
       Employee headDevelopment = new Employee("bar", "Development");
       Employee headTesting = new Employee("bim", "Testing");
       Employee developer1 = new Employee("edu", "Developer");
       Employee developer2 = new Employee("tilos", "Developer");
       Employee tester1 = new Employee("pako", "Tester");
       Employee tester2 = new Employee("deko", "Tester");
       ceo.setSubordinates(Arrays.asList(headDevelopment, headTesting));
       headDevelopment.setSubordinates(Arrays.asList(developer1, developer2));
       headTesting.setSubordinates(Arrays.asList(tester1, tester2));
       printEmployee(ceo,"");
    }


    private static void printEmployee(Employee emp, String indent) {
        StringBuilder builder = new StringBuilder(indent).append(emp.toString());
        System.out.println(builder.toString());
        List<Employee> subordinates = emp.getSubordinates();
        if(subordinates == null) return ;
        for(Employee subEmp: subordinates)
            printEmployee(subEmp, indent + "    ");
    }
}
