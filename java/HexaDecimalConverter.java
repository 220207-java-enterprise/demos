import java.util.Scanner;

public class HexaDecimalConverter {
    
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in); 
        System.out.println("Enter Decimal Number");
        int n = myObj.nextInt();
        System.out.println(convert(n));
    }

    public static String convert(int n) {
        int i = (int) Math.ceil(((double)n-15)/16);
        if (n <= 9) {
            return Integer.toString(n);
        }
        else if (n >= 10 && n < 16){
            return String.valueOf((char)(n+55));
        }
        else {
            return convert(i) + convert(n-16*i);
        }
    }



    
}