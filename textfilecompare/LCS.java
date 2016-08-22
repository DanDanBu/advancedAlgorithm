
package textfilecompare;

import static java.lang.Integer.max;
import java.util.ArrayList;


public class LCS {
    String[] t1;
    String[] t2;
    String[] LCS;
    int[][] array;
    int[][] prev;
    int countTime =0;
    
    //define LCS current array and previous array size.
    void LCS(int t1Size, int t2Size){
        t1 = new String[t1Size+1];
        t2 = new String[t2Size+1];
        array = new int[t1Size + 1][t2Size + 1];
        prev = new int[t1Size + 1][t2Size + 1];
        LCS = new String[max(t1Size, t2Size)+1];
    }
    
    public void LCSExe(ArrayList<String> file1, ArrayList<String> file2){
        String fileLine1, fileLine2;
        //init array[x][0] and array[0][x] = 0
        for(int i=0; i<file1.size(); i++){
            for(int j=0; j<file2.size(); j++){
                array[i][j] = 0;
                prev[i][j] = 0;
            }
        }
        //upper left = 1, left = 2, up = 3
        //with these numbers, we can define the status of each step.
        for(int i = 0; i < file1.size(); i++){
            fileLine1 = file1.get(i);
            t1[i] = fileLine1;
            for(int j = 0; j < file2.size(); j++){
                fileLine2 = file2.get(j);
                t2[j] = fileLine2;
                if(fileLine1.compareTo(fileLine2) == 0){
                    array[i+1][j+1] = array[i][j] + 1;
                    prev[i+1][j+1] = 1;
                }else{
                    if(array[i][j+1] < array[i+1][j]){
                        array[i+1][j+1] = array[i+1][j];
                        prev[i+1][j+1] = 2;
                    }
                    else{
                        array[i+1][j+1] = array[i][j+1];
                        prev[i+1][j+1] = 3;
                    }
                }
            }
        }
        System.out.println("LCS length is = " + array[file1.size()][file2.size()]);
        System.out.println();
        System.out.println("LCS is : ");
        print_LCS(file1.size(), file2.size());
        System.out.println();
        //System.out.println(countTime);
    }

    //printout LCS function
    public void print_LCS(int i, int j){
        countTime ++;
        if(i == 0 || j == 0)
            return ;
        
        if(prev[i][j] == 1){
            LCS[i] = t1[i-1];
            print_LCS(i-1, j-1);
            System.out.println(t1[i-1]);
        }
        else if(prev[i][j] == 3)
            print_LCS(i-1, j);
        else if(prev[i][j] == 2)
            print_LCS(i, j-1);
        
    }
}
