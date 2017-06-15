package com.edutilos.designpattern.prototype;

/**
 * Created by edutilos on 15.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            Person p1 = new Person(1, "foo", 10, 100.0, true);
            Person p1Cloned = (Person) p1.clone();
            p1Cloned.setName("modified");
            System.out.println(p1.toString());
            System.out.println(p1Cloned);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
