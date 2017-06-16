package com.edutilos.java8;

import com.edutilos.main.Person;
import com.sun.javafx.scene.control.behavior.OptionalBoolean;

import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

/**
 * Created by edutilos on 16.06.17.
 */
public class StreamExample1 {
    public static void main(String[] args) {
        test10();
    }



  private static Random rand = new Random();
    private static final String newline = "\r\n";


    private static void test10()  {
      List<Person> personList = generatePersonList();
      Map<Boolean , List<Person>> partitioned1 = personList.parallelStream()
              .collect(Collectors.partitioningBy(p -> p.getAge() > 10));


        System.out.println("<<Paritioned1>>");
        partitioned1.forEach((k,v)-> System.out.println(String.format("%b => %s", k, v.toString())));


        Map<Boolean, String> partitioned2 = personList.stream()
                .collect(Collectors.partitioningBy(p-> p.getAge() > 10,
                        Collectors.mapping(Person::getName, Collectors.joining(" , "))));

        System.out.println("<<Partitioned2>>");
        partitioned2.forEach((k,v)-> System.out.println(String.format("%b => %s", k, v)));


        //collectinAndThen
        List<String> names = personList.stream()
                .map(Person::getName)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        System.out.println(names);

        //findAny
        Optional<Person> opPerson = personList.stream()
                .filter(p -> p.getAge()> 10)
                .findAny();

        opPerson.ifPresent(p-> System.out.println(p));
        //findFirst
        opPerson = personList.stream()
                .filter(p-> p.getAge()> 10)
                .findFirst();
        opPerson.ifPresent(p-> System.out.println(p));

        //allMatch
        boolean allMatch = personList.stream().allMatch(p-> p.getAge() > 10);
        //anyMatch
        boolean anyMatch = personList.stream().anyMatch(p-> p.getAge()> 10);
        //noneMatch
        boolean noneMatch = personList.stream().noneMatch(p-> p.getAge()> 10);
        System.out.println(String.format("allMatch = %b", allMatch));
        System.out.println(String.format("anyMatch = %b", anyMatch));
        System.out.println(String.format("noneMatch = %b", noneMatch));
    }

    private static void test9() {
        List<Person> personList = generatePersonList();
        String joinedNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining());

        System.out.println(String.format("joined names = %s", joinedNames));

        joinedNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining("; "));
        System.out.println(String.format("joined names = %s", joinedNames));

        joinedNames = personList.stream()
                .map(Person::getName)
                .collect(Collectors.joining("; ", "pre-", "-post"));
        System.out.println(String.format("joined names = %s", joinedNames));


        //grouping
        personList = Arrays.asList(
                new Person(1, "foo", 10, 100.0, true),
                new Person(1, "bar", 20, 200.0 , false),
                new Person(2, "bim", 30 , 300.0, true),
                new Person(2, "pako", 40 , 400.0, false)
        );


        Map<Long , Long> idGroupCount = personList.parallelStream()
                .collect(Collectors.groupingBy(Person::getId, Collectors.counting()));


         idGroupCount.forEach((k, v)-> System.out.println(String.format("%d => %d", k,v)));


         Map<Long , String> idGroupName  = personList.parallelStream()
                 .collect(Collectors.groupingBy(Person::getId,
                         Collectors.mapping(Person::getName, Collectors.joining(" , "))));

         idGroupName.forEach((k,v)-> System.out.println(String.format("%d => %s", k, v)));


          Map<Long , List<String>> grouping1 = personList.parallelStream()
                  .collect(Collectors.groupingBy(Person::getId,
                          Collectors.mapping(Person::getName, Collectors.toList())));
          grouping1.forEach((k, v)-> System.out.println(String.format("%d => %s", k , v.toString())));


           Map<Long , Set<String>> grouping2 = personList.parallelStream()
                   .collect(Collectors.groupingBy(Person::getId,
                           Collectors.mapping(Person::getName, Collectors.toSet())));
           grouping2.forEach((k,v)-> System.out.println(String.format("%d => %s", k , v.toString())));
    }


    private static void test8() {
        List<Person> personList = generatePersonList();
        Map<Long , String> idToName = personList.stream()
                .collect(Collectors.toMap(p-> p.getId(), p->p.getName()));

        idToName.forEach((k, v)-> System.out.println(String.format("%d => %s", k, v)));

        idToName = personList.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName));
        idToName.forEach((k, v)-> System.out.println(String.format("%d => %s", k, v)));

        personList = Arrays.asList(
           new Person(1, "foo", 10, 100.0, true),
                new Person(1, "bar", 20, 200.0 , false),
                new Person(2, "bim", 30 , 300.0, true),
                new Person(2, "pako", 40 , 400.0, false)
        );

        idToName = personList.stream()
                .collect(Collectors.toMap(Person::getId, Person::getName,
                        (oldName, newName)-> String.join(", ", oldName, newName)));

        System.out.println();
        idToName.forEach((k,v)-> System.out.println(String.format("%d => %s", k, v)));
    }


    private static void test7() {
        DoubleSummaryStatistics doubleSummaryStatistics = new DoubleSummaryStatistics();
        Double [] doubleNumbers = {
                rand.nextDouble()*100 ,
                rand.nextDouble()*100 ,
                rand.nextDouble()*100,
                rand.nextDouble()*100
        };


        for(Double n: doubleNumbers) {
            System.out.print(n + " ");
        }
        System.out.println();

        for(Double number: doubleNumbers) {
            doubleSummaryStatistics.accept(number);
        }


        double average = doubleSummaryStatistics.getAverage();
        double max = doubleSummaryStatistics.getMax();
        double min = doubleSummaryStatistics.getMin();
        double sum  = doubleSummaryStatistics.getSum();
        long count = doubleSummaryStatistics.getCount();

        StringBuilder sb = new StringBuilder();
        sb.append("min = ").append(min).append(newline)
                .append("max = ").append(max).append(newline)
                .append("sum = ").append(sum).append(newline)
                .append("average = ").append(average).append(newline)
                .append("count = ").append(count).append(newline);

        System.out.println(sb.toString());


        List<Person> personList =  generatePersonList();
        IntSummaryStatistics personAgeStats = personList.stream()
                .map(Person::getAge)
                .collect(IntSummaryStatistics::new, IntSummaryStatistics::accept,
                        IntSummaryStatistics::combine);

        printIntSummaryStatistics(personAgeStats);

        personAgeStats = personList.stream()
                .map(p-> p.getAge())
                .collect(()-> new IntSummaryStatistics(),
                        (accu , age)-> accu.accept(age),
                        (base , toAdd)-> base.combine(toAdd));

        printIntSummaryStatistics(personAgeStats);


        DoubleSummaryStatistics wageStatistics =
                personList.stream()
                .collect(Collectors.summarizingDouble(Person::getWage));

        IntSummaryStatistics ageStatistics =
                personList.stream()
                .collect(Collectors.summarizingInt(Person::getAge));

        IntSummaryStatistics nameLengthStatistics =
                personList.stream()
                .collect(Collectors.summarizingInt(p-> p.getName().length()));

        System.out.println(wageStatistics);
        System.out.println(ageStatistics);
        System.out.println(nameLengthStatistics);
    }

    private static void printIntSummaryStatistics(IntSummaryStatistics personAgeStats) {
        double avg = personAgeStats.getAverage();
        long count = personAgeStats.getCount();
        int max = personAgeStats.getMax();
        int min = personAgeStats.getMin();
        long sum = personAgeStats.getSum();
       StringBuilder sb = new StringBuilder();
       sb.append("min = ").append(min).append(newline)
               .append("max = ").append(max).append(newline)
               .append("avg = ").append(avg).append(newline)
               .append("sum = ").append(sum).append(newline)
               .append("count = ").append(count).append(newline)
               .append(newline);

        System.out.println(sb.toString());
    }


    private static void test6() {
        List<Person> personList = generatePersonList();
        //max age , min age , average age , sum of age
        OptionalInt maxAge = personList.stream()
                .mapToInt(p -> p.getAge())
                .max();

        maxAge.ifPresent(age-> System.out.println(String.format("max age = %d", age)));


        OptionalInt minAge = personList.stream()
                .mapToInt(Person::getAge)
                .min();

        minAge.ifPresent(age -> System.out.println(String.format("min age = %d", age)));


        OptionalDouble avgAge = personList.stream()
                .mapToInt(Person::getAge)
                .average();

        avgAge.ifPresent(avg -> System.out.println(String.format("average age = %.3f", avg)));

        int sumAge = personList.stream()
                .mapToInt(Person::getAge)
                .sum();

        System.out.println(String.format("sumAge = %d", sumAge));


         Optional<Person> youngestPerson  = personList.stream()
                 .min((p1, p2)-> {
                     if(p1.getAge() < p2.getAge()) return -1;
                     else if(p1.getAge() > p2.getAge()) return 1;
                     return 0;
                 });

         youngestPerson.ifPresent(p -> System.out.println(p.toString()));

         //count
        long count = personList.stream()
                .count();
        System.out.println(String.format("count = %d", count));
        count = personList.stream()
                .mapToLong(p-> 1L)
                .sum();
        System.out.println(String.format("count = %d", count));

        count = personList.stream()
                .map(p-> 1L)
                .reduce(0L, Long::sum);
        System.out.println(String.format("count = %d", count));

        count = personList.stream()
                .reduce(0L, (accu , p)-> accu + 1L, Long::sum);
        System.out.println(String.format("count = %d", count));

        //collector
        List<String> names = personList.stream()
                .map(Person::getName)
                .collect(()-> new ArrayList<String>(),
                        (list , name)-> list.add(name),
                        (l1 , l2)-> l1.addAll(l2));

        System.out.println(names);

        names = personList.stream()
                .map(Person::getName)
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        System.out.println(names);

        names = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toList());
        System.out.println(names);


        Set<String> namesSet = personList.stream()
                .map(Person::getName)
                .collect(Collectors.toSet());
        System.out.println(namesSet);
    }

    private static void test5() {
        // STream#peek()
        int sum = Stream.<Integer>of(1, 2,3, 4,5)
               .peek(n -> System.out.println(String.format("Original number = %d", n)))
               .filter(n-> n%2 == 0)
               .peek(n -> System.out.println(String.format("Filtered number = %d", n)))
               .map(n-> n*n*n)
               .peek(n-> System.out.println(String.format("Mapped number = %d", n)))
               .reduce(0, Integer::sum);
        System.out.println(String.format("sum = %d", sum));


        //Stream#forEach()
        generatePersonList().parallelStream()
                .forEach(p-> System.out.println(p.toString()));

        List<Person> personList  = generatePersonList();
                personList.parallelStream()
                .filter(p-> p.getWage() <= 200.0)
                .forEach(p -> p.setWage(p.getWage()+ 1000.0));

                personList.parallelStream()
                        .forEach(System.out::println);

        System.out.println();
        //map(), mapToInt() , mapToLong() , mapToDouble()
        Stream<String> names = Arrays.stream(new String[]{"foo", "bar", "bim"})
                .map(n-> n.toUpperCase());
        names.forEach(System.out::println);
        System.out.println();

        IntStream intStream = IntStream.range(1, 10);
        intStream.mapToDouble(n -> n*n)
                .forEach(System.out::println);
        System.out.println();
        intStream = IntStream.range(1, 10);
        intStream.mapToLong(n-> n*n)
                .forEach(n -> System.out.println(n));

        Stream.<Integer>of(1, 2, 3)
                .flatMap(n -> Stream.<Integer>of(n, n+1, n+2))
                .forEach(n -> System.out.print(String.format("%d ; ", n)));
        System.out.println();


        //reduce 1
        Integer res = personList.stream()
                .reduce(0 , (accu , p)-> accu + p.getAge(), Integer::sum)
                ;

        System.out.println(String.format("res = %d", res));

        IntStream intStream2 = IntStream.range(1, 10);
        res = intStream2.reduce(0 , (x, y)-> x + y);
        System.out.println(String.format("res = %d", res));

        res = IntStream.range(1, 10)
                .reduce(0 , (x, y)-> x+ y );


        Optional<Person>  oldest = personList.parallelStream()
                .reduce((p1, p2)-> p1.getAge()> p2.getAge()?p1:p2);

        System.out.println(String.format("oldest = %s", oldest.toString()));
    }


    private static List<Person> generatePersonList() {
       List<Person> ret = Arrays.asList(
           new Person(1L , "foo", 10, 100.0, true),
               new Person(2L, "bar", 20 , 200.0, false),
               new Person(3, "bim", 30 , 300.0, true)
       ) ;

       return ret ;
    }


    private static void test4() {
        Stream<String> s1 = Arrays.stream(new String[]{"foo", "bar", "bim"})
                .limit(10).distinct().sorted();

        Stream<Integer> s2 = Arrays.stream(new Integer[]{1, 2,3});
        Stream<Long> s3 = Arrays.stream(new Long[]{1L, 2L, 3L});
        Stream<Double> s4 = Arrays.stream(new Double[]{1.0D , 2.0D , 3D});

        Set<Integer> set = new HashSet<>();
        set.add(1); set.add(2); set.add(3);
        s2 = set.stream();
        s2 = set.parallelStream();

        List<Double> list = new ArrayList<>();
        s4 = list.stream();
        s4 = list.parallelStream();

        String str = "foo bar 123";
        IntStream chars = str.chars()
                .filter(n-> !Character.isDigit((char)n) && !Character.isWhitespace((char)n))
                .limit(10)
                .sorted();

        str="foo,bar,bim";
        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(s -> System.out.println(s));

        Pattern.compile(",")
                .splitAsStream(str)
                .forEach(System.out::println);


        Path path = Paths.get("people.xml");
        try(Stream<String> lines = Files.lines(path)) {
             lines.forEach(line-> System.out.println(line));
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }

        path = Paths.get(".");
        try(Stream<Path> parts = Files.walk(path, FileVisitOption.FOLLOW_LINKS)) {
            parts.forEach(System.out::println);
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void test3() {
        Stream<String> s = Stream.of("foo", "bar", "bim");
        s.forEach(System.out::println);

        String [] arr = {"foo", "bar", "bim"};
        s = Stream.of(arr);


        s = Stream.<String>builder()
                .add("foo")
                .build();


        IntStream intStream = IntStream.range(0, 100);
        intStream = IntStream.rangeClosed(0, 100);


        Stream<Integer> s2 = Stream.<Integer>empty();

        Stream<Long> s3 = Stream.<Long>iterate(0L, n-> n+1).limit(10);

         s3 = Stream.<Long>iterate(1L , n-> n+1)
                 .filter(StreamExample1::isOdd)
                 .map(n-> n* 2)
                 .limit(10);

         s3.forEach(System.out::println);


         Random rand = new Random();
         s3 = Stream.<Long>generate(()-> rand.nextLong())
                 .limit(10)
                 .sorted();


         s3 = Stream.<Long>generate(StreamExample1::constantValue)
                 .limit(10);

         s3 = Stream.<Long>generate(StreamExample1::nextLongValue)
                 .limit(10);

         IntStream is = rand.ints().limit(10).sorted();
        LongStream ls = rand.longs().limit(10).sorted();
        DoubleStream ds = rand.doubles().limit(10).sorted();

          is = IntStream.generate(rand::nextInt).limit(10).sorted();
          ls = LongStream.generate(rand::nextLong).limit(10).sorted();
          ds = DoubleStream.generate(rand::nextDouble).limit(10).sorted();

    }


    private static Long constantValue() {
        return 10L ;
    }

    private static Long begin = 0L ;
    private static Long nextLongValue() {
        return begin++;
    }


    private static boolean isOdd(Long n) {
        return n% 2 != 0 ;
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


