import java.util.Scanner;

public class HelloWorld {

    private static int someVal = 10;
    private String username;

    /*-----------------METHOD SIGNATURE-------------------*/
    public static void main(String... args) throws Exception {
    
        HelloWorld example = new HelloWorld();
        HelloWorld example2 = new HelloWorld();
        
        example.username = "wsingleton";
        example2.username = "aanderson";
        System.out.println(example.username);
        System.out.println(example2.username);
        
        HelloWorld.someVal = 20;
        System.out.println(example.someVal);
        System.out.println(example2.someVal);
        
        postFixPreFix();
        weirdAssignments();
        
        methodA();
        methodA("test");
        methodA("test1", "test2");
        
        System.out.println("You entered: " + getUserInput());
        
    }
    
    public static void postFixPreFix() {
    	int i = 0;
    	System.out.println(i); // 0
	System.out.println(i++); // 0
	System.out.println(++i); // 2
    }
    
    public static void weirdAssignments() {
        int y, z;
        y = z = 10;
        System.out.println(y); // 10
        System.out.println(z); // 10
    }
    
    public static void methodA() {
        System.out.println("hello from methodA!");
    }

    public static void methodA(String s) {
        System.out.println("hello from methodA with 1 arg!");
    }
    
    public static void methodA(String s, String s2) {
        System.out.println("hello from methodA with 2 args!");
    }
    
    //public static void methodA(String s, Object s2) {
    //    System.out.println("hello from methodA with 2 args!");
    //}
    
    public static String getUserInput() {
       Scanner consoleReader = new Scanner(System.in);
       System.out.print("Please enter some value: ");
       return consoleReader.next();
    }
    
}

