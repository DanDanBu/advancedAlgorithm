/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textfilecompare;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 * @author James
 */
public class TextFileCompare {

    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileReader fr1 = new FileReader("D:\\testFile1.txt");
        FileReader fr2 = new FileReader("D:\\testFile2.txt");
        BufferedReader br1 =new BufferedReader(fr1);
        BufferedReader br2 =new BufferedReader(fr2);
        
        LCS lcs = new LCS();
        
        ArrayList<String> list1 = new ArrayList<String>();
        ArrayList<String> list2 = new ArrayList<String>();
        String data1, data2;
        int countFile1 = 0 , countFile2 = 0;
        Object temp;
        
        while((data1 = br1.readLine()) != null){
            StringTokenizer st = new StringTokenizer(data1, ",.");
            while(st.hasMoreElements()){
                temp = st.nextElement();
                list1.add((String) temp);
                countFile1 += 1;
                //System.out.println(temp);
            }
        }
        System.out.println();
        System.out.println();
        
        while((data2 = br2.readLine()) != null){
            StringTokenizer st = new StringTokenizer(data2, ",."); 
            while(st.hasMoreElements()){
                temp = st.nextElement();
                list2.add((String)temp);
                countFile2 += 1;
                //System.out.println(temp);
            }
        }
        System.out.println();
        lcs.LCS(list1.size(), list2.size());
        lcs.LCSExe(list1, list2);
        
        System.out.println("File1 : ");
        for(int i=0; i<list1.size(); i++){
            boolean checkSame = false;
            for(int j=0; j < lcs.LCS.length; j++){
                if(list1.get(i).equals(lcs.LCS[j]) == true){
                    System.out.println(list1.get(i));
                    checkSame = true;
                    break;
                }
            }
            if(!checkSame){
                System.out.print("***");
                System.out.println(list1.get(i));
            }
        }
        
        System.out.println();
        System.out.println("File2 : ");
        for(int i=0; i<list2.size(); i++){
            boolean checkSame = false;
            for(int j=0; j < lcs.LCS.length; j++){
                if(list2.get(i).equals(lcs.LCS[j]) == true){
                    System.out.println(list2.get(i));
                    checkSame = true;
                    break;
                }
            }
            if(!checkSame){
                System.out.print("***");
                System.out.println(list2.get(i));
            }
        }
        //System.out.println(list1.get(0));
        //System.out.println(list2.get(0));
        
    }
    
}
