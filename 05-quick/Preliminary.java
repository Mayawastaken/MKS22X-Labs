import java.util.*;
import java.io.*;
public class Preliminary{

  public static void switches(int[] data, int l, int r){ //apparently switch is a keyword... i got sm errors LOL
    int temp = data[l];
    data[l] = data[r];
    data[r] = temp;
  }

  public static int partition ( int [] data, int start, int end){
    //i dont need to import random hehe
    boolean ifGroup = true; //to deal with worst caseish stuff
    int pivotInd = (int)(Math.random()*(end-start)) + start;
    int pivot = data[pivotInd];
    int left = start-1;
    switches(data, pivotInd, end);
    for(int i = start; i <= end - 1; i++){
      if (data[i] < pivot){
        left++;
        switches(data, left, i);
      }
      else if (data[i] == pivot){
        if (ifGroup){
          ifGroup = false;
          left++;
          switches(data, left, i);
        }
        else{
          ifGroup = false;
        }
      }
    }
    switches(data, left+1, end);
    return left+1;
  }

  public static int seHelper(int[] data, int start, int end, int k){
    
  }

  public static int quickselect(int[]data, int k){
    //uses my helper
  }

  public static void main(String[] args){
    int[] ary1 = new int[]{99, 99, 4, 3, 2, 1, 0, 99, 99};
    System.out.println("Original: " + Arrays.toString(ary1));
    int pivot1 = partition(ary1, 2, 6);
    System.out.println("Pivot value: "+ary1[pivot1]+ ", Pivot index: " + pivot1);
    System.out.println("Modified: " + Arrays.toString(ary1));
  }
}
