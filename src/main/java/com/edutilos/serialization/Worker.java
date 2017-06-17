package com.edutilos.serialization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by edutilos on 17.06.17.
 */
public class Worker implements Externalizable {

    private long id;
    private String name;
    private int age;
    private double wage;
    private boolean active;

    public Worker(long id, String name, int age, double wage, boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }


    public Worker() {
    }

    public Worker(String name, int age, double wage, boolean active) {
        this.name = name;
        this.age = age;
        this.wage = wage;
        this.active = active;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
       out.writeLong(id);
       out.writeObject(name);
       out.writeInt(age);
       out.writeDouble(wage);
       out.writeBoolean(active) ;
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        id = in.readLong();
        name = (String)in.readObject();
        age = in.readInt();
        wage = in.readDouble();
        active = in.readBoolean();
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
        return String.format("[%d,%s,%d,%.2f,%b]", id , name,
                age , wage, active);
    }
}
