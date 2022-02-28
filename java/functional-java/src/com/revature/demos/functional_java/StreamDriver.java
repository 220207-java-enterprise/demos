package com.revature.demos.functional_java;

import com.revature.demos.functional_java.models.State;
import com.revature.demos.functional_java.models.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamDriver {


    /*
            Java 8 introduced a package: java.util.function

                - a set of functional interfaces

                - there are more than 40 individual interfaces provided by this package

                - organized into 4 main categories (a 5th is the Runnable interface; not a part of this package!):

                    - Supplier<T>
                        + T get();
                        + takes in no value; returns a value

                    - Consumer<T>
                        + void accept(T val);
                        + takes in a value; returns no value

                    - Predicate<T>
                        + boolean test(T val);
                        + takes in a value; returns a boolean

                    - Function<T, R>
                        + T = the parameter, R = return type
                        + R apply(T val);
                        + takes in a value of type T, returns a value of type R

                The fifth type of functional interface is not actually in the java.util.function
                package. It comes from java.lang, and is the Runnable interface (since java 1.0)
                    + void run();
                    + takes in nothing; returns nothing

         */

    public static void main(String[] args) {

        User ebezener = new User("Ebenezer", 29);
        User wezley = new User("Wezley", 31);
        User cameron = new User("Cameron", 24);
        User janay = new User("Janay", 24);
        User aidanA = new User("Aidan", 21);
        User aidanR = new User("Aidan", 26);
        User amelia = new User("Amelia", 43);
        User bao = new User("Bao", 45);
        User nobody = new User("", 34);
        User anotherNobody = new User("", 33);


        // NOTE: Arrays#asList returns a fixed-size, immutable list of the provided values
        List<User> users = new ArrayList<>(Arrays.asList(ebezener, wezley, cameron, janay, amelia, bao, nobody, anotherNobody));

        List<User> emptyNameUsers = new ArrayList<>();

        for (User user : users) {
            if (user.getName().isEmpty()) {
                emptyNameUsers.add(user);
            }
         }

        System.out.println(emptyNameUsers.size());

        long numberOfEmptyNameUsers = users.stream()
                                           .filter(user -> user.getName().isEmpty())
                                           .count();

        System.out.println(numberOfEmptyNameUsers);

        //----------------------------------------------------------------------------

        State florida = new State("Florida", wezley, aidanA, aidanR);
        State maryland = new State("Maryland", ebezener, janay);
        State colorado = new State("Colorado", bao, amelia);
        State michigan = new State("Michigan", cameron, nobody, anotherNobody);

        List<State> states = new ArrayList<>(Arrays.asList(florida, maryland, colorado, michigan));

        System.out.println(states.stream()
                                  .flatMap(state -> state.getResidentUsers().stream())
                                  .count());

        int sum = 0;
        for (State state :states) {
            if (state.getName().equals("Florida")) {
                for (User resident: state.getResidentUsers()) {
                    sum += resident.getAge();
                }
                System.out.println("Average age = " + sum / state.getResidentUsers().size());
            }
        }


        System.out.println(states.stream()
                                 .filter(state -> state.getName().equals("Florida"))
                                 .flatMap(state -> state.getResidentUsers().stream())
                                 .mapToInt(User::getAge)
                                 .average()
                                 .orElseThrow(RuntimeException::new));

    }

}
