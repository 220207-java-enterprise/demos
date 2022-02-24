package com.revature.model;

import java.util.Objects;

public class Person implements Comparable<Person> {

    private String firstName;
    private String lastName;
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    // Return value
    // 0 (equal)
    // < 0 (this object is less than argument object)
    // > 0 (this object is greater than argument object)
    public int compareTo(Person o) {
        return this.age - o.age;
    }

    // 5 v. 6
    // 5 - 6 < 0 (person of age 5 is LESS than person of age 6)

    // 6 v. 6
    // 6 - 6 == 0 (person of age 6 is EQUAL to person of age 6)

    // 7 v. 6
    // 7 - 6 == 1 (person of age 7 is GREATER than person of age 6)
}
