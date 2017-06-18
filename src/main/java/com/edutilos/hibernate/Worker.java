package com.edutilos.hibernate;


import javax.persistence.*;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id @GeneratedValue
    private long id ;
    @Column(name="name")
    private String name;
    @Column(name="age")
    private int age;
    @Column(name="wage")
    private double wage;
    @Column(name="active")
    private boolean active;

    public Worker(String name, int age, double wage, boolean active) {
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    public Worker() {
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
        return String.format("%d,%s,%d,%.2f,%b",
                id , name, age, wage, active);
    }
}

