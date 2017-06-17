package com.edutilos.serialization;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by edutilos on 17.06.17.
 */
public class Runner {
    public static void main(String[] args) {
        test2();
    }



    private static void test2() {
        List<Person> personList = Arrays.asList(
           new Person(1, "foo", 10, 100.0, true),
                new Person(2, "bar", 20, 200.0, false),
                new Person(3, "bim", 30, 300.0, true)
        );
        String fileName = "people-serialized.out";
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(personList);
        } catch(IOException ex) {
            ex.printStackTrace();
        }


        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<Person> readList = (List<Person>)ois.readObject();
            for(Person p: readList)
                System.out.println(p.toString());
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private static void test1() {
        //writing bunch of Workers
        List<Worker> workerList = Arrays.asList(
           new Worker(1, "foo", 10, 100.0, true),
                new Worker(2, "bar", 20 , 200.0, false),
                new Worker(3, "bim", 30, 300.0, true)
        );

        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("workers.out"))) {
           oos.writeObject(workerList);
        } catch(IOException ex) {
            ex.printStackTrace();
        }


        //readng workers
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("workers.out"))) {
            List<Worker> readList = (List<Worker>)ois.readObject();
            for(Worker w: readList) {
                System.out.println(w.toString());
            }
        } catch(IOException ex) {
            ex.printStackTrace();
        } catch(ClassNotFoundException ex2) {
            ex2.printStackTrace();
        }
    }
}
