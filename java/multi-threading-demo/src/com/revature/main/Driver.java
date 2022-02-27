package com.revature.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Driver {

    // Application thread: is the main thread that RUNS the main method
    // the main method is the entry point to the Java application
    public static void main(String[] args) throws InterruptedException {

/*      // method #1: extending the Thread class
        PrintNumbers task1 = new PrintNumbers();
        task1.start(); // Starts up the new thread and has it execute the overridden run method

        // method #2: implementing the Runnable interface
        Runnable r = new CalculateNthFibonacciNumber();
        Thread t1 = new Thread(r); // pass the Runnable into the Thread constructor
        t1.start(); // start up the thread

        */

        /*
            Fibonacci Demo
            Take in many different Fibonacci requests, and hand the request over to other threads
            to eventually fulfill and provide an output
         */
        Scanner sc = new Scanner(System.in);

        /*
            Method #3: Use an executor service
            - This is a high level API for dealing with Threads
            - Threads are computationally intensive to start up
            - So, instead you can create them all at once, and then re-use the threads over and over
            -> ExecutorService es = Executors.newFixedThreadPool(10);
         */
        // This creates a pool containing 10 threads
        // Whenever a thread is free to have some additional code execute on it,
        // Then utilize it
        ExecutorService es = Executors.newFixedThreadPool(10);

        while (true) {
            System.out.println("Enter a number that corresponds to the n-th fibonacci # that you would like to see (or -1 to quit): ");
            int n = Integer.parseInt(sc.nextLine());

            if (n <= -1) break;

            /*Runnable r = new CalculateNthFibonacciNumber(n);
            Thread t = new Thread(r);
            t.start();*/

            Runnable r = new CalculateNthFibonacciNumber(n);
            es.execute(r);
        }

        es.shutdown();

        /*
            Race Condition Example
         */

        RaceConditionExample rce = new RaceConditionExample();

        List<Thread> threads = new ArrayList<>();

        Runnable myRunnable = () -> {
            for (int i = 0; i < 10000; i++) {
                rce.increment();
            }

            for (int i = 0; i < 10000; i++) {
                rce.decrement();
            }
        };

        // Create 100 Thread objects that perform the increment and decrement operation
        for (int i = 0; i < 100; i++) {
            threads.add(new Thread(myRunnable));
        }

        // Start up all 100 threads
        for (int i = 0; i < 100; i++) {
            threads.get(i).start();
        }

        // Wait for all 100 threads to finish
        for (int i = 0; i < 100; i++) {
            threads.get(i).join(); // join will wait for the thread to finish before moving on to the next line of code
            // inside of "this" thread (main thread)
        }

        System.out.println(rce.getValue());

    }

}
