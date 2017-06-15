package com.edutilos.designpattern.prototype;

public class Person implements  Cloneable{
    private long id ;
    private String name;
    private int age;
    private double wage;
    private boolean active;

    public Person(long id, String name, int age, double wage, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    public Person() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    @Override
    public String toString() {
        return String.format("[%d,%s,%d,%.2f,%b]",
                id , name, age, wage, active);
    }


    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Person(id, name, age, wage, active);
    }
}
