// Your First Program
import java.util.*;

class HelloWorld {
    public static void main(String[] args) {
        List<String> mylist = new ArrayList<>();
        mylist.add("Alice");
        mylist.add("Bob");
        mylist.add("Charlie");
        mylist.remove(1);
        System.out.println(mylist.size());
    }
}
        