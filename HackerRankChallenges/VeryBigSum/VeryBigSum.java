import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class VeryBigSum {

    public static void main(String[] args) {
        int n = 0;
        long result = 0;

        Scanner in = new Scanner(System.in);
        
        System.out.print("Please Enter the number of terms you are adding together: ");
        n = in.nextInt(); 
        int arr[] = new int[n]; 
        
        for(int arr_i=0; arr_i < n; arr_i++){
            System.out.print("Enter term "+(arr_i+1)+": ");
            arr[arr_i] = in.nextInt();
            result= result+arr[arr_i];
        }
        System.out.println("Your result is: "+result);
    }
}