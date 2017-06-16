package com.edutilos.thread;

import java.util.concurrent.TimeUnit;

/**
 * Created by edutilos on 16.06.17.
 */
public class JoinExample {
    public static void main(String[] args) {
        System.out.println("Start");
        Thread t = new Thread(()-> {
            for(int i=0; i< 4; ++i) {
                System.out.println(String.format("counter = %d", i));
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch(Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

        t.start();
        //make main thread wait for t to terminate
        try {
            t.join();
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("Done");
    }
}
