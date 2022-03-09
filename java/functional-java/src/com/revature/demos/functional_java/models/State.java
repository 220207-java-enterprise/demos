package com.revature.demos.functional_java.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class State {

    private String name;
    private List<User> residentUsers;

    public State(String name, User... residentUsers) {
        this.name = name;
        this.residentUsers = new ArrayList<>(Arrays.asList(residentUsers));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getResidentUsers() {
        return residentUsers;
    }

    public void setResidentUsers(List<User> residentUsers) {
        this.residentUsers = residentUsers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        State state = (State) o;
        return Objects.equals(name, state.name) && Objects.equals(residentUsers, state.residentUsers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, residentUsers);
    }

    @Override
    public String toString() {
        return "State{" +
                "name='" + name + '\'' +
                ", residentUsers=" + residentUsers +
                '}';
    }

}
