package com.revature.main;

public class CalculateNthFibonacciNumber implements Runnable {

    private int n;

    public CalculateNthFibonacciNumber(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        long result = calculateNthFib(this.n);
        System.out.println("The " + this.n + "th fib is " + result);
    }

    long calculateNthFib(long n) {
        if (n <= 1) return 1;

        return calculateNthFib(n - 1) + calculateNthFib(n - 2);
    }
}
