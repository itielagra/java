import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AngryProfessor {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            System.out.print("Enter the class size for test case "+(a0+1)+": ");
            int n = in.nextInt();
            System.out.print("Enter the threshold for test case "+(a0+1)+": ");
            int k = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                System.out.print("Enter the arrival time of student "+(a_i+1)+": ");
                a[a_i] = in.nextInt();
                if(a[a_i]<=0){
                    k=k-1;
                }
            }
            if(k<=0){
                System.out.println("The result for test case "+(a0+1)+": NO Class");
            }
            else{
                System.out.println("The result for test case "+(a0+1)+": YES Class");
            }
        }
    }
}
