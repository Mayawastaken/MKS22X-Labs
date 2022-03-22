import java.util.*;
import java.io.*;
public class Merge{     // know rutime of stuff and why, knw when u cant do stuff like data[0] = smth (ex in for each or 2d arr or 1d arr)
  public static int [] merge(int [] left, int[] right){
    int[] combined = new int[left.length+right.length];
    //int minLen = Math.min(left.length, right.length);
    int leftInd = 0, rightInd = 0, combinedInd = 0;
    while (leftInd < left.length && rightInd < right.length){
      if (left[leftInd] < right[rightInd]){
        int temp = left[leftInd];
        combined[combinedInd] = temp;
        leftInd++;
      }
      else{
        int temp = right[rightInd];
        combined[combinedInd] = temp;
        rightInd++;
      }
      combinedInd++;
    }
    System.out.println(Arrays.toString(combined)); //up till here we good hm
    System.out.println("left ind: " + leftInd + "\nright ind: " + rightInd);
    if (leftInd == left.length){
      for (int i = rightInd; i < right.length; i++){
        int temp = right[i];
        combined[combinedInd] = temp;
        combinedInd++;
      }
    }
    else if (rightInd == right.length){
      for (int i = leftInd; i < left.length; i++){
        int temp = left[i];
        combined[combinedInd] = temp;
        combinedInd++;
      }
      //add rest of left and make sure it acc transfers data w ar[i] = ar2[i2] like is it the acc value or smth else
    }
    return combined;
    //return a new array that is the merged version of left and right
  }

  public static void mergesort(int [] data){
    // int [] temp  =  mergeSortH(data);
    //copy temp into data
  }

  public static int[] mergesortH(int [] data){
    // if more than 1 element{
    //   left = copy half of data
    //   right = copy other half of data
    //   sort each half and merge them together
    // }
    return (new int[]{});
  }

  public static void main(String[] args){
    int[] a1 = new int[]{0,6,7,8,9};
    int[] a2 = new int[]{1,2,3,4, 10};
    System.out.println(Arrays.toString(merge(a1,a2)));


  }

}
