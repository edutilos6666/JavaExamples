package com.edutilos.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 16.06.17.
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
       Thread producer = new Thread(()-> {
           while(true) {
               produce();

               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

       Thread consumer = new Thread(()-> {
           while(true) {
               consume();

               try {
                   Thread.sleep(1);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
       });

       producer.start();
       consumer.start();
       try {
           producer.join();
           consumer.join();
       } catch(InterruptedException ex) {
           System.err.println(ex.getMessage());
       }
    }



    private static List<Integer> numbers = new ArrayList<>();
    private static int counter = 0;

    private static synchronized  void produce() {
      try {
        while(numbers.size() >= 10)  Thread.currentThread().wait();
        numbers.add(counter++);
        System.out.println(String.format("Produce = %s", numbers.toString()));
        Thread.currentThread().notify();
      } catch(Exception ex) {
         // ex.printStackTrace();
      }
    }

    private static synchronized  void consume() {
        try {
            while(numbers.isEmpty()) Thread.currentThread().wait();
            numbers.remove(numbers.size()-1);
            System.out.println(String.format("Consume = %s", numbers.toString()));
            Thread.currentThread().notify();
        } catch(Exception ex) {
           // ex.printStackTrace();
        }
    }
}
