import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class SolveMeFirst {


    static int adder(int a, int b) {
      return a + b;
   }

   
 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a;
        int b;
        int sum;

        System.out.print("Enter first number: ");
        a = in.nextInt();
        System.out.print("Enter second number: ");
        b = in.nextInt();
        sum = adder(a, b);
        System.out.println("The sum of "+a+" and "+b+" is "+sum);
   }
}
