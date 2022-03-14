import java.io.*;
import java.util.*;
public class Preliminary{

  static int partition ( int [] data, int start, int end){
    Random rand = new Random();
    int pivot = data[rand.nextInt((end - start) + 1) + start];
    int right = start-1;
    for(int i = start; i <= end - 1; i++){
      if (data[i] < pivot){
        right++;
        int temp = data[right];
        data[right] = data[i];
        data[i] = temp;
      }
    }
    int temp2 = data[right+1];
    data[right+1] = data[end];
    data[end] = temp2;
    return (right + 1);
  }


  public static void main(String[] args){
    int[] ary1 = new int[]{99, 99, 0, 1, 2, 3, 4, 99, 99};
    System.out.println(partition(ary1, 0, ary1.length-1));
  }
}
