package com.edutilos.thread;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by edutilos on 16.06.17.
 */
public class Example1 {
    public static void main(String[] args) {
        test3();
    }


    private static void test3() {
        Thread t1  = new Thread(() -> {
            while(true) {
          /*      increaseBalance();
                decreaseBalance();*/
          updateBalance();
                try {
                    Thread.sleep(0);
                } catch(InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while(true) {
              /*  increaseBalance();
                decreaseBalance();*/
              updateBalance();
                try {
                    Thread.sleep(0);
                } catch(InterruptedException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });

        Thread t3 = new Thread(()-> {
             while(true) {
              monitorBalance();
                 try {
                     Thread.sleep(1000);
                 } catch(InterruptedException ex) {
                     System.err.println(ex.getMessage());
                 }
             }
        });

        t1.start();
        t2.start();
        t3.start();

        try {
            t1.join();
            t2.join();
            t3.join();
        } catch(InterruptedException ex) {
            System.err.println(ex.getMessage());
        }
    }



    private static void test2() {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(Example1::synchronizedPrint));
        threads.add(new Thread(Example1::synchronizedPrint));
        threads.forEach(Thread::start);

        threads.forEach(t -> {
            try {
                t.join();
            } catch(InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        });
    }

    private static void test1() {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(()-> print()));
        threads.add(new Thread(()-> print()));
        threads.add(new Thread(Example1::print));


        threads.forEach(Thread::start);
        threads.forEach(t -> {
            try {
                t.join();
            } catch(InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }) ;


    }


    private static double balance = 1 ;
    private static synchronized void updateBalance() {
        balance +=1 ;
        balance -= 1;
    }

    private static   void increaseBalance() {
       balance += 1 ;
    }
    private static void decreaseBalance() {
        balance -= 1 ;
    }

    private static void monitorBalance() {
        System.out.println(String.format("Balance is = %.2f", balance));
    }


    private static synchronized  void synchronizedPrint() {
        String threadName = Thread.currentThread().getName();
        for(int i=0 ; i< 5; ++i) {
            System.out.println(String.format("%s => %d", threadName, i));
            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    private static void print() {
        String threadName = Thread.currentThread().getName();
        for(int i=0; i< 5; ++i) {
            System.out.println(String.format("%s => %d", threadName, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
