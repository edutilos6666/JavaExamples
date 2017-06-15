package com.edutilos.designpattern.filter;

/**
 * Created by edutilos on 15.06.17.
 */
public class Programmer {
  private long id;
  private String name;
  private int age;
  private double wage;
  private boolean active;

    public Programmer(long id, String name, int age, double wage, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    public Programmer() {
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
        return String.format("[%d,%s,%d,%.3f,%b]",id, name, age, wage, active);
    }

    @Override
    public boolean equals(Object obj) {
        try {
            Programmer other = (Programmer)obj;
            return this.id == other.id ;
        } catch(Exception ex) {
            return false ;
        }

        //return false ;
    }
}
