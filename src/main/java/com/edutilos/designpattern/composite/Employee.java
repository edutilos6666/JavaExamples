package com.edutilos.designpattern.composite;

import java.util.List;

/**
 * Created by edutilos on 15.06.17.
 */
public class Employee {
  private String name;
  private String dept;
  private List<Employee> subordinates;

    public Employee(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }

    private final String newline = "\r\n";
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("[%s,%s]", name, dept));
        return builder.toString();
    }
}
