import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class DiagonalDifference {

    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size N of the NxN matrix: ");
        int n = in.nextInt();
        
        int a[][] = new int[n][n]; //Matrix
        int prim[] = new int [n]; //Primary Diagonal
        int sec[] = new int [n]; //Secondary Diagonal
        int result=0;

        for(int a_i=0; a_i < n; a_i++){
            for(int a_j=0; a_j < n; a_j++){
                System.out.print("Enter row "+(a_i+1)+" col "+(a_j+1)+": ");
                a[a_i][a_j] = in.nextInt();
            
                if(a_i == a_j && a_i+a_j==n-1){
                    prim[a_i]=a[a_i][a_j];
                    sec[a_i]=a[a_i][a_j];
                }
                else if(a_i == a_j){
                    prim[a_i]=a[a_i][a_j];
                }
                else if(a_i+a_j==n-1){
                    sec[a_i]=a[a_i][a_j];
                }
            }
        }
        for(int i=0; i<n;i++){
            result = prim[i]-sec[i]+result;
        }
        System.out.println("The difference between the primary diagonal and the secondary diagonal: "+Math.abs(result));
    }
}