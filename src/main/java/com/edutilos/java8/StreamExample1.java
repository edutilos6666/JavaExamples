package com.edutilos.java8;

import com.sun.javafx.scene.control.behavior.OptionalBoolean;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by edutilos on 16.06.17.
 */
public class StreamExample1 {
    public static void main(String[] args) {
        test2();
    }


    private static void test2() {
        /*OptionalInt;
        OptionalDouble;
        OptionalLong;
        OptionalBoolean; */
        Optional<String> op = Optional.empty();
        op = Optional.of("foobar");
        if(op.isPresent()) {
            System.out.println(String.format("Optional value = %s", op.get()));
        } else {
            System.out.println("Optional is empty.");
        }

        op.ifPresent(v-> System.out.println(v));

        OptionalDouble od  = OptionalDouble.of(100.0);
        od.ifPresent(v-> System.out.println(v));

        OptionalInt max = IntStream.of(1, 2, 3, 4,5).max();
        max.ifPresent(v-> System.out.println(String.format("max value = %d", max.getAsInt())));

        Optional<Double> maxDouble = Arrays.asList(1.0, 2.0, 3.0, 4.0)
                .stream().max((x, y)-> x.compareTo(y));
        maxDouble.ifPresent(v-> System.out.println(String.format("Max value = %.3f", maxDouble.get())));
    }

    private static void test1() {
        List<Integer> numbers = Arrays.asList(10, 20 , 30, 40, 50);
        double sum = numbers.stream()
                .filter(n -> n> 0 )
                .map(n -> Math.pow(n, 3))
                .reduce(0.0, Double::sum);
        System.out.println(String.format("sum = %.2f", sum));


        sum = numbers.parallelStream()
                .filter(n -> n > 0)
                .map(n -> Math.pow(n , 3))
                .reduce(0.0, Double::sum);
        System.out.println(String.format("sum = %.2f", sum));


        Stream<Integer> s1 = numbers.stream();
        List<Double> doubleNumbers = Arrays.asList(10., 20. , 30., 40.);
        Stream<Double> s2 = doubleNumbers.stream();
        s2 = doubleNumbers.parallelStream();
        s2 = s2.filter(n -> n > 0);
        s2 = s2.map(n -> n*n*n);
        s2 = s2.sorted();
        double res = s2.reduce(0.0, (x,y)-> x + y);

         doubleNumbers.stream()
                 .filter(n -> n % 2 == 0)
                 .map(n -> n*n)
                 .sorted((x,y)-> {
                     if(x > y) return -1 ;
                     else if(x < y) return 1 ;
                     return 0;
                 })
                 .distinct()
                 .forEach(System.out::println);

    }
}


