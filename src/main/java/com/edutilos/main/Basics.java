package com.edutilos.main;

import java.util.*;

/**
 * Created by edutilos on 14.06.17.
 */
public class Basics {
    private static final String newline = "\r\n";

    public static void main(String[] args) {
     testPersonDAOImplMysql();
    }


    private static void testPersonDAOImplMysql() {
        //here add jvm option -ea , in order to enable assertion
      PersonDAO dao = new PersonDAOImplMysql();
        ((PersonDAOImplMysql)dao).connect();
        ((PersonDAOImplMysql)dao).dropTable();
        ((PersonDAOImplMysql)dao).createTable();
        dao.save(new Person(1, "foo", 10 , 100.0, true));
        dao.save(new Person(2, "bar", 20 , 200.0, false));
        dao.save(new Person(3, "bim", 30 , 300.0, true));
        List<Person> all = dao.findAll();
        assert 3 == all.size();
        Person first = dao.findById(1L);
        assert 1 == first.getId();
        assert "foo".equals(first.getName());
        assert 10 == first.getAge();
        assert 100.0 == first.getWage();
        assert true == first.isActive();
        //update
        dao.update(1L , new Person(1L, "new_foo", 66 , 666.6, false));
        first = dao.findById(1L);
        assert "new_foo".equals(first.getName());
        assert 66 == first.getAge();
        assert 666.6 == first.getWage();
        assert false == first.isActive();
        //remove
        dao.remove(2l);
        all = dao.findAll();
        assert 2 == all.size();
        ((PersonDAOImplMysql)dao).disconnect();
    }


    private static void testPersonDAOImplMem() {
        //here add jvm option -ea , in order to enable assertion
       PersonDAO dao = new PersonDAOImplMem();
       dao.save(new Person(1, "foo", 10, 100.0, true));
       dao.save(new Person(2, "bar", 20, 200.0, false));
       dao.save(new Person(3, "bim", 30 , 300.0, true));
       // assert 1 == 1;
        List<Person> all = dao.findAll();
        assert 3 == all.size();
        Person first = dao.findById(1L);
        assert 1 == first.getId();
        assert "foo".equals(first.getName());
        assert 10 == first.getAge();
        assert 100.0 == first.getWage();
        assert true == first.isActive();

        //update
        dao.update(1, new Person(1, "new_foo", 66, 666.6, false));
        first = dao.findById(1);
        assert "new_foo".equals(first.getName());
        assert 66 == first.getAge();
        assert 666.6 == first.getWage();
        assert false == first.isActive();
        //remove
        dao.remove(1L);
        all = dao.findAll();
        assert 2 == all.size();

    }

    private static void testPerson() {
         Person p1 , p2;
         p1 = new Person(1 , "foo", 10 , 100.0, true);
         p2 = new Person(2, "bar", 20 , 200.0, false);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }

    private static void test1() {
        long id = 100l;
        String name = "foo";
        int age = 10 ;
        double wage = 100.0D;
        boolean active = true ;

        System.out.println(String.format("[%d, %s , %d , %.3f , %b]", id , name , age,  wage , active));

        age = 10 ;
        if (age < 10) {
            System.out.println("age is lt 10");
        } else if(age >= 10 && age < 100) {
            System.out.println("age is in [10, 100)");
        } else {
            System.out.println("age is too large.");
        }


        //testing while
        int counter = 0;
        while(counter < 10) {
            System.out.println(String.format("counter = %d", counter));
            ++counter ;
        }


        //testing for
        for(int i=0 ; i< 10; ++i) {
            System.out.println(String.format("i = %d", i));
        }

        //testing for for array
        int [] numbers  = {1 , 2, 3, 4, 5};
        for(int number: numbers) {
            System.out.println(String.format("number = %d", number));
        }

        //testing for for arraylist
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        for(int number : numbers2) {
            System.out.println(String.format("number2 = %d", number));
        }

        //testing for for linkedlist
        List<Integer> numbers3 = new LinkedList<>();
        numbers3.add(10);
        numbers3.add(20);
        numbers3.add(30);
        numbers3.add(40);
        for(int number: numbers3) {
            System.out.println(String.format("number3 = %d", number));
        }


        //map with lambda expression
        Map<String , Integer> people = new HashMap<>();
        people.put("foo", 10);
        people.put("bar", 20);
        people.put("bim", 30);
        people.forEach((k, v)-> {
            System.out.println(String.format("%s => %d", k , v));
        });
    }


    private static void testUserInput(){
         long id ;
         String name;
         int age ;
         double wage ;
         boolean active = false ;
         Scanner sc = new Scanner(System.in);
          try {
              System.out.println("Insert id: ");
              id = Long.parseLong(sc.next());
              System.out.println("Insert name: ");
              name = sc.next();
              System.out.println("Insert age: ");
              age = Integer.parseInt(sc.next());
              System.out.println("Insert wage: ");
              wage = Double.parseDouble(sc.next());
              System.out.println("Insert active: ");
              String boolStr = sc.next();
              if(boolStr.equalsIgnoreCase("true")) active = true ;
              else if(boolStr.equalsIgnoreCase("false")) active = false ;
              StringBuilder builder = new StringBuilder();
              builder.append("Id = ").append(id).append(newline)
                      .append("Name = ").append(name).append(newline)
                      .append("Age = ").append(age).append(newline)
                      .append("Wage = ").append(wage).append(newline)
                      .append("Active = ").append(active).append(newline);
              System.out.println(builder.toString());
          } catch(Exception ex) {
              System.err.println(ex.getMessage());
              ex.printStackTrace();
          }

    }


}
