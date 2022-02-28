package com.revature.demos.functional_java.models;

import java.util.Objects;

public class Batch {

    private String name;
    private TechStack stack;

    public Batch(String name, TechStack stack) {
        this.name = name;
        this.stack = stack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TechStack getStack() {
        return stack;
    }

    public void setStack(TechStack stack) {
        this.stack = stack;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Batch batch = (Batch) o;
        return Objects.equals(name, batch.name) && stack == batch.stack;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, stack);
    }

    @Override
    public String toString() {
        return "Batch{" +
                "name='" + name + '\'' +
                ", stack=" + stack +
                '}';
    }

}
