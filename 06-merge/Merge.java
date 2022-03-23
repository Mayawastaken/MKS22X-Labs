import java.util.*;
import java.io.*;
public class Merge{     // know rutime of stuff and why, knw when u cant do stuff like data[0] = smth (ex in for each or 2d arr or 1d arr)
  public static int [] merge(int [] left, int[] right){
    int[] combined = new int[left.length+right.length];
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
    }
    return combined;
    //return a new array that is the merged version of left and right
  }

  public static void mergesort(int [] data){
    int [] temp  =  mergesortH(data);
    for(int i = 0; i < data.length; i++){
      data[i] = temp[i];
    }
  }

  public static int[] mergesortH(int [] data){
    if (data.length > 1){
      int[] left = new int[data.length/2];
      int[] right = new int[data.length - left.length];
      for (int i = 0; i < left.length; i++){
        int temp = data[i];
        left[i] = temp;
      }
      for (int i = 0; i < right.length; i++){
        int temp = data[i+left.length];
        right[i] = temp;
      }
      left = mergesortH(left);
      right = mergesortH(right);
      return merge(left, right);
    }
    else{
      return data;
    }
  }

  public static void main(String[] args){
    int[] a1 = new int[]{0,6,7,8,9,11,13};
    int[] a2 = new int[]{1,2,3,4,10};
    int[] a3 = new int[]{345,45,-45,324,23,1,-2,3};
    System.out.println(Arrays.toString(merge(a1,a2)));
    System.out.println(Arrays.toString(mergesortH(a3)));
    System.out.println(Arrays.toString(new int[]{}));
    mergesort(a3);
    System.out.println(Arrays.toString(a3));
  }

}
