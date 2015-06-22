
package comparealgospeed;

import java.util.ArrayList;

/**
 *
 * @author DanDanBu
 */
public class MergeSort {
    public ArrayList<Float> floatList;
    public MergeSort(ArrayList<Float> input){
        floatList = new ArrayList<Float>();
        for(int i=0; i<input.size(); i++)
            floatList.add(input.get(i));
    }
    
    public void sort(){
        floatList = mergeSort(floatList);
    }
    public ArrayList<Float> mergeSort(ArrayList<Float> all){
        ArrayList<Float> left = new ArrayList<Float>();
        ArrayList<Float> right = new ArrayList<Float>();
        int center;
        
        if(all.size() == 1)
            return all;
        else{
            center = all.size()/2;
            for(int i=0; i<center; i++)
                left.add(all.get(i));
            for(int i=center; i<all.size(); i++)
                right.add(all.get(i));
            
            left = mergeSort(left);
            right = mergeSort(right);
            
            merge(left, right, all);
        }
        return all;
    }
    
    private void merge(ArrayList<Float> left, ArrayList<Float> right, ArrayList<Float> all){
        int leftInd = 0, rightInd = 0, allInd = 0;
        
        while (leftInd < left.size() && rightInd < right.size()){
            if ((left.get(leftInd).compareTo(right.get(rightInd)))<0) {
                all.set(allInd,left.get(leftInd));
                leftInd++;
            }else{
                all.set(allInd, right.get(rightInd));
                rightInd++;
            }
            allInd++;
        }
        
        ArrayList<Float> temp;
        int tempInd;
        if (leftInd >= left.size()) {
            temp = right;
            tempInd = rightInd;
        }else {
            temp = left;
            tempInd = leftInd;
        }
 
        for (int i=tempInd; i<temp.size(); i++) {
            all.set(allInd, temp.get(i));
            allInd++;
        }
    }
    
    public void show(){
        System.out.println("Sorted:");
        for(int i=0; i< floatList.size();i++){
            System.out.println(floatList.get(i) + " ");
        }
    }
}
