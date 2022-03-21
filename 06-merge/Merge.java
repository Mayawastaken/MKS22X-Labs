public class Merge{     // know rutime of stuff and why, knw when u cant do stuff like data[0] = smth (ex in for each or 2d arr or 1d arr)
  public static int [] merge(int [] left, int[] right){
    int[] combined = new int[left.length+right.length];
    int minLen = Math.min(left.length, right.length);
    int leftInd = 0, rightInd = 0, combinedInd = 0;
    while (leftInd < left.length && rightInd < right.length){
      if (left[leftInd] > right[rightInd]){
        combined[combinedInd] = left[leftInd];
        leftInd++;
      }
      else{
        combined[combinedInd] = right[rightInd];
        rightInd++;
      }
      combinedInd++;
    }
    if (leftInd == left.length - 1){
      for (int i = rightInd; i < right.length; i++){
        combined[combinedInd] = right[i];
      }
    }
    else if (rightInd == right.length - 1){
      //add rest of left and make sure it acc transfers data w ar[i] = ar2[i2] like is it the acc value or smth else
    }
    return combined;
    //return a new array that is the merged version of left and right
  }

  public static void mergesort(int [] data){
    int [] temp  =  mergeSortH(data);
    copy temp into data
  }

  public static int[] mergesortH(int [] data){
    if more than 1 element{
      left = copy half of data
      right = copy other half of data
      sort each half and merge them together
    }
  }

}
