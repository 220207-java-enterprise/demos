package com.revature.main;

import com.revature.model.Person;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

    public static void main(String[] args) {
        List<String> myStrings = new ArrayList<>();

        myStrings.add("Peaches");
        myStrings.add("Apples");
        myStrings.add("Bananas");
        myStrings.add("Apricots");
        myStrings.add("Plums");

        System.out.println(myStrings);

        Collections.sort(myStrings); // Natural ordering of a String object is
        // alphabetically

        System.out.println(myStrings);

        List<Person> myPeople = new ArrayList<>();

        myPeople.add(new Person("Bach", "Tran", 24));
        myPeople.add(new Person("John", "Doe", 15));
        myPeople.add(new Person("Jane", "Doe", 23));

        Collections.sort(myPeople);

        System.out.println(myPeople);

        // Comparator is similar to Comparable except for it is "third-party"
        // For example, if your natural ordering of Person objects is by age,
        // But you want to sort by first name, then you can create a comparator,
        // and pass that into the .sort method as a second argument

        myPeople.add(new Person("Bob", "Jones", 15));
        myPeople.add(new Person("John", "Weiser", 15));

        Collections.sort(myPeople, new AgeThenFirstNameThenLastNameComparator());

        System.out.println(myPeople);
    }

}
