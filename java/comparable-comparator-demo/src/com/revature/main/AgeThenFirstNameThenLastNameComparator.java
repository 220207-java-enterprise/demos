package com.revature.main;

import com.revature.model.Person;

import java.util.Comparator;

public class AgeThenFirstNameThenLastNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getAge() == o2.getAge()) {
            if (o1.getFirstName().equals(o2.getFirstName())) {
                return o1.getLastName().compareTo(o2.getLastName());
            }

            return o1.getFirstName().compareTo(o2.getFirstName());
        }

        return o1.getAge() - o2.getAge();
    }
}
