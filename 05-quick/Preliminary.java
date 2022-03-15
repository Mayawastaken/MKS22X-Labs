import java.io.*;
import java.util.*;
public class Preliminary{

  static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int pivotInd = rand.nextInt((end - start) + 1) + start;
    int pivot = data[pivotInd];
    int left = start-1;
    int right = end+1;
    for(int i = start; i <= end - 1; i++){
      if (data[i] < pivot && i < pivotInd){
        left++;
        int templ = data[left];
        data[left] = data[i];
        data[i] = templ;
      }
      else if (data[i] > pivot && i > pivotInd){
        right--;
        int tempr = data[right];
        data[right] = data[i];
        data[i] = tempr;
      }
    }
    // int temp2 = data[left+1];
    // data[left+1] = data[pivotInd];
    // data[pivotInd] = temp2;
    return (left + 1);
  }


  public static void main(String[] args){
    int[] ary1 = new int[]{99, 99, 4, 3, 2, 1, 0, 99, 99};
    System.out.println("Original: " + Arrays.toString(ary1));
    int pivot1 = partition(ary1, 2, 6);
    System.out.println("Pivot value: "+ary1[pivot1]+ ", Pivot index: " + pivot1);
    System.out.println("Modified: " + Arrays.toString(ary1));
  }
}
