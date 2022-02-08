import java.util.Arrays;


public class ArrayDriver {

    public static void main(String[] args) {
        arrayBasics();
    }
    
    public static void arrayBasics() {
        int[] myIntArray = new int[10]; // instantiates a new array object with 10 elements (default values applied)
        System.out.println(Arrays.toString(myIntArray));
        
        // Array literals
        int[] preloaded = { 1, 2, 3, 4, 5 }; // once created, an array's size cannot be changed
        System.out.println(Arrays.toString(preloaded));
        
        preloaded[0] = 0;
        System.out.println(Arrays.toString(preloaded));
        
        // preloaded[10000] = 0; // throws IndexOutOfBoundsException
        
        preloaded[preloaded.length - 1] = -1;
        System.out.println(Arrays.toString(preloaded));
    }

}
