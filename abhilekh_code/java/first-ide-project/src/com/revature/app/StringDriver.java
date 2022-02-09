package com.revature.app;

import java.util.Arrays;

public class StringDriver {

    public static void main(String[] args){
        String s1 = "hello";
        System.out.println(s1+", world");

        // Strings are immutable, once their value is instantiated, it cannot be changed
        s1.concat(", world");
        System.out.println(s1);

        // Assigning a new value to s1 changes, old s1 value "hello" is eligible for garbage collection because it has  nothing pointing to it
        s1 = s1.concat(", world");
        System.out.println(s1);

        // Common string API methods
        char firstChar = s1.charAt(0);
        System.out.println(firstChar);

        String allButTheFirst = s1.substring(1);
        System.out.println(allButTheFirst);

        String anotherSubString = s1.substring(1,4); // inclusive lower bound / non-inclusive upper bound
        System.out.println(anotherSubString);

        int stringLength = s1.length();
        System.out.println(stringLength);

        String quickFox ="The quick brown fox jumped over the lazy dog.";
        String[] words = quickFox.split(" ");
        System.out.println(Arrays.toString(words));

        String anotherSplitExample = "here-we-go";
        String[] moreWords = anotherSplitExample.split("-");
        System.out.println(Arrays.toString(moreWords));

        System.out.println("--------------------------------------------");

        // String Pool

        // A special area of heap memory that stores unique string objects within

        String s2 = "hello";
        String s3 = "hello";
        System.out.println(s2.equals(s3)); // is value of s2 same as s3 (equality)
        System.out.println(s2==s3); // is s2 the same object in memory? (heap memory)

        // can we change this?
        String s4 = new String("hello");
        System.out.println(s2.equals(s4));
        System.out.println(s2==s4);

        s4 = s4.intern(); // tells Java to link "s4" to the String pool within the heap memory
        System.out.println(s2 == s4); // true

        String s5="";
        String s6 = s5.concat("hello");
        System.out.println(s2==s5); // false


        //-----------------------------------------------------

        // StringBuilder/Buffer
        StringBuilder strBuilder = new StringBuilder("some initial string value");
        // method chaining is possible, bc append method returns "this" instance of the object
        strBuilder.append(", appended value")
                .append(", and another")
                .append(", last one");

        String builtString = strBuilder.toString();

        System.out.println(strBuilder);
        // System.out.println(strBuilder == builtString);//cannot use this bc they are different objects types
        System.out.println(strBuilder.equals(builtString));// false because they are different objects
    }
}
