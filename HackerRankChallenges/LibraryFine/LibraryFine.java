import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LibraryFine {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("First enter the actual return date:");
        System.out.print("Enter the day number: ");
        int d1 = in.nextInt();
        System.out.print("Enter the month number: ");
        int m1 = in.nextInt();
        System.out.print("Enter the year number: ");
        int y1 = in.nextInt();
        System.out.println("Now enter the expected return date:");
        System.out.print("Enter the day number: ");
        int d2 = in.nextInt();
        System.out.print("Enter the month number: ");
        int m2 = in.nextInt();
        System.out.print("Enter the year number: ");
        int y2 = in.nextInt();
         
        System.out.println(fee(d1,m1,y1,d2,m2,y2));
    }
    
    public static int fee(int d1, int m1, int y1, int d2, int m2, int y2){
        int total = 0;
        
        if(y1 > y2){
            total = 10000;
        }
        else if(y1 == y2){
            if(m1 > m2){
                total = (m1-m2)*500;
            }
            else if(m1 == m2){
                if(d1 > d2){
                    total = (d1-d2)*15;
                }
                else{
                    total = 0;
                }
            }
        }
    
        return total;
    }
}