package org.ds.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class Basic {
    public static void main(String[] args) {

        Runnable rn = () -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Current thread is in runnable and name is : " +Thread.currentThread().getName());
        };

        Callable cal = () -> {
            System.out.println("Current thread is in callable and name is : " +Thread.currentThread().getName());
            return "callable statement";
        };


        Thread the1 = new Thread(rn);
        the1.start();
        Thread the2 = new Thread(rn);
        the2.start();

        System.out.println(Thread.currentThread().getName());

//        FutureTask<String> task = the1.
    }
}
