import java.util.*;
import java.io.*;
public class Quick{

  public static void switches(int[] data, int l, int r){ //apparently switch is a keyword... i got sm errors LOL
    int temp = data[l];
    data[l] = data[r];
    data[r] = temp;
  }

  // public static int partition2 ( int [] data, int start, int end){
  //   boolean ifGroup = true;
  //   int pivotInd = (int)(Math.random()*(end-start)) + start;
  //   int pivot = data[pivotInd];
  //   int left = start+1;
  //   int right = end;
  //   switches(data, pivotInd, end);
  //   while(right - left > 0){ //as right > left og
  //     int ind = left+1;
  //     if (data[ind] < data[start]){
  //       left++;
  //       switches(data, left, ind);
  //     }
  //     else if (data[ind] > data[start]){
  //       right--;
  //       switches(data, right, ind);
  //     }
  //     else{
  //       if (ifGroup){
  //         ifGroup = false;
  //         switches(data, left, ind);
  //       }
  //       else{
  //         ifGroup = true;
  //         switches(data, right, ind);
  //       }
  //     }
  //   }
  //   if (data[left] > data[start]){
  //     left--;
  //   }
  //   switches(data, left, start);
  //   return left;
  // }
  // above is a 2nd version of partition for fun, still not dutch or faster tho

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
          ifGroup = true;
        }
      }
    }
    switches(data, left+1, end);
    return left+1;
  }

  public static int seHelper(int[] data, int k, int start, int end){
    int pivotInd = partition(data, start, end);
    if (pivotInd - start > k){
      return seHelper(data, k, start, pivotInd - start);
    }
    else if (pivotInd - start < k){
      return seHelper(data, k - pivotInd + (start-1), pivotInd + 1, end);
    }
    else{
      return data[pivotInd];
    }
  }

  public static int quickselect(int[]data, int k){
    return seHelper(data, k, 0, data.length - 1);
  }

  public static void soHelper(int[] data, int start, int end){ //hmm this seems too short but also im p sure this works
    if (start < end){
      int pivot = partition(data, start, end);
      soHelper(data, start, pivot -1);
      soHelper(data, pivot + 1, end);
    }
  }

  public static void quicksort(int[]data){
    soHelper(data, 0, data.length - 1);
  }

  public static void main(String[] args){
    int[] ary1 = new int[]{99, 99, 4, 3, 2, 1, 0, 99, 99};
    System.out.println("Original: " + Arrays.toString(ary1));
    int pivot1 = partition(ary1, 2, 6);
    System.out.println("Pivot value: "+ary1[pivot1]+ ", Pivot index: " + pivot1);
    System.out.println("Modified: " + Arrays.toString(ary1));
  }
}
