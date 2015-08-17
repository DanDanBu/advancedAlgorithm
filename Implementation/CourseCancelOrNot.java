import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int course = input.nextInt();
        int count = 0;
        boolean[] cancelOrNot = new boolean[course];
        int[] person = new int[2];
        
        for(int i=0; i<course; i++){
            count = 0;
            person[0] = input.nextInt();
            person[1] = input.nextInt();
            
            int[] arrive = new int[person[0]];
            
            for(int j=0; j<arrive.length; j++){
                arrive[j] = input.nextInt();
                if(arrive[j] <= 0)
                    count++;
            }
            
            if(count >= person[1])
                cancelOrNot[i] = false;
            else
                cancelOrNot[i] = true;
        }
        
        for(int i=0; i<course; i++){
            if(cancelOrNot[i] == true)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
