import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();
        String str = input.next();
        int r = 0;
        r = input.nextInt();
        
        char[] letter = str.toCharArray();
        for(int i=0; i<letter.length; i++){
            if(Character.isLowerCase(letter[i]))
                letter[i] = (char) (((letter[i] - 'a' + r) % 26) + 'a');
            if(Character.isUpperCase(letter[i]))
                letter[i] = (char) (((letter[i] - 'A' + r) % 26) + 'A');
            System.out.print(letter[i]);
        }
        
    }
}
