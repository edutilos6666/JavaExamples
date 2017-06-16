package com.edutilos.thread;

/**
 * Created by edutilos on 16.06.17.
 */
public class Example3 {
    public static void main(String[] args) {
        Thread.currentThread().setUncaughtExceptionHandler(new CustomUncaughtExceptionHandler());
        throw new RuntimeException("hello world");
    }

    private static class CustomUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(String.format("Thread = %s, msg = %s", t.getName(),
                    e.getMessage()));
        }
    }
}

