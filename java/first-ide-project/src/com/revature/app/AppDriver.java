// The package declaration must be the first non-comment line (if it is included at all)
package com.revature.app;

import java.util.Arrays;

public class AppDriver {

    // Quick command for generating the main method signature: main
    public static void main(String[] args) {

        if (args.length != 0) {
            System.out.println(Arrays.toString(args));
        }
        // Quick command for System.out.println() is: sout
        System.out.println("Hello, IntelliJ!");

        // Add a breakpoint to line 13 for debugging
        int x = 10;
        System.out.println(x);

    }

}
