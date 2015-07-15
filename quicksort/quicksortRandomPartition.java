/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quicksortandrandpartition;

import java.util.ArrayList;
import java.util.Random;


/**
 *
 * @author user
 */
public class RandPart {
 
     public float quick_select(ArrayList<Float> a, int k, int left, int right) {

        int pivot=findpivot(a,left,right);
        if(pivot==k-1){
            return a.get(pivot);
        }
        if(k-1<pivot){
            return quick_select(a, k, left, pivot-1);
        }
        else {
            return quick_select(a, k, pivot+1, right);
        }

    }

    private static int findpivot(ArrayList<Float> a, int left, int right) {

        float pivot = a.get((left+right)/2);
        while(left<right){
            while(a.get(left)<pivot){
                left++;
            }
            while(a.get(right)>pivot){
                right--;
            }

            if(left<=right){
                swap(a,left,right);
                left++;
                right--;
            }

        }
        return left;
    }

    private static void swap(ArrayList<Float> a, int i, int j) {

        float temp=a.get(i);
        a.set(i, a.get(j));
        a.set(j, temp);
        
    }

}
