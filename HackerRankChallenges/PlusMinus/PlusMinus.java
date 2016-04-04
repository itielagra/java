import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class PlusMinus {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        double pos=0d;
        double neg = 0d;
        double zero=0d;
        
        System.out.print("Enter the number of terms in the sequence: ");
        int n = in.nextInt();
        
        int arr[] = new int[n];
        for(int arr_i=0; arr_i < n; arr_i++){
            
            System.out.print("Enter term "+(arr_i+1)+": ");
            arr[arr_i] = in.nextInt();
            if(arr[arr_i] == 0){
                zero++;
            }
            else if(arr[arr_i] > 0){
                pos++;
            }
            else if(arr[arr_i] < 0){
                neg++;
            }
        }
        System.out.println(pos/n);
        System.out.println(neg/n);
        System.out.println(zero/n);
        
    }
}