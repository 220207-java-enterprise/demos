package com.revature.main;

public class RaceConditionExample {

    private int value = 0;

    // Lock and key model
    // you can create a synchronized block of code that requires a "key"
    // to enter and execute
    // A key can be any object of your choice

    // Once a Thread takes a key, no other thread can enter any synchronized blocks that require that key
    // Whenever the Thread that has the key is done running the synchronized block that it is in,
    // it will return the key to be grabbed by another Thread
    private Object key = new Object();

    public void increment() {
        synchronized(key) {
            value = value + 1;
        }
    }

    public void decrement() {
        synchronized(key) {
            value = value - 1;
        }
    }

    public int getValue() {
        return this.value;
    }
}
