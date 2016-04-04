import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter the number of rows you would like for the staircase: ");
        int n = in.nextInt();
    
        for (int i=1; i<=n;i++  ){
            for(int j=0;j<n-i;j++){
                System.out.print(" ");   
            }
            for(int k=1;k<=i;k++){
                System.out.print("#");
            }
            System.out.print("\n");
        }
    }
}
