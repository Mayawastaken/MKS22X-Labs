public class RecursionForReal{
  public static boolean groupSum(int start, int[] nums, int target){
    if (start < nums.length && target != 0){
      return (groupSum(start+1, nums, target - nums[start]) || groupSum(start+1, nums, target));
    }
    return (target == 0);
  }

  public static boolean groupSum6(int start, int[] nums, int target){
    if (start < nums.length && target != 0){
      if (nums[start] == 6){
        return (groupSum6(start+1, nums, target - nums[start]));
      }
      else{
        return (groupSum6(start+1, nums, target - nums[start]) || groupSum6(start+1, nums, target));
      }
    }
    if (start < nums.length){
      if (nums[start] == 6){
        return false;
      }
      else{
        return groupSum6(start+1, nums, target);
      }
    }
    return (target == 0);
  }

  public static boolean groupSum5(int start, int[] nums, int target) {
    if (start < nums.length && target != 0){
      if (nums[start] % 5 == 0){
        if (start + 1 < nums.length && nums[start+1] == 1){
          return (groupSum5(start+2, nums, target - nums[start]));
        }
        else{
          return (groupSum5(start+1, nums, target - nums[start]));
        }
      }
      else{
        return (groupSum5(start+1, nums, target - nums[start]) || groupSum5(start+1, nums, target));
      }
    }
    if (start < nums.length){
      if (nums[start] % 5 == 0){
        return false;
      }
      else{
        return groupSum5(start+1, nums, target);
      }
    }
    return (target == 0);
  }

  public boolean groupNoAdj(int start, int[] nums, int target) {
    if (start < nums.length && target != 0){
      return (groupNoAdj(start+2, nums, target - nums[start]) || groupNoAdj(start+1, nums, target));
    }
    return (target == 0);
  }

  public static boolean groupSumClump(int start, int[] nums, int target) {
    if (start < nums.length && target != 0){
      int i = 1;
      while (i < nums.length - start){
        if (nums[start] == nums[start + i]){
          i++;
        }
        else{
          break;
        }
      }
      return (groupSumClump(start+i, nums, target - i * nums[start]) || groupSumClump(start+i, nums, target));
    }
    return (target == 0);
  } //NO FULL WORK

  // public static boolean split53(int[] nums) {
  //
  // }


  public static void main(String[] args){
    int[] test1 = {2,4,8};
    int[] test2 = {2,3,7,9};
    int[] test3 = {5,6,2};
    int[] test4 = {2,4,8};
    int[] test5 = {1,2,4,8,1};
    int[] test6 = {2,2,4,8};
    System.out.println("groupSum----------");
    System.out.println(groupSum(0, test1, 10));
    System.out.println(groupSum(0, test1, 14));
    System.out.println(groupSum(0, test1, 9));
    System.out.println(groupSum(0, test2, 12));
    System.out.println("groupSum6---------");
    System.out.println(groupSum(0, test3, 8));
    System.out.println(groupSum(0, test3, 9));
    System.out.println(groupSum(0, test3, 10));
    System.out.println(groupSum(0, test3, 11));
    System.out.println("groupSumClump---------");
    System.out.println(groupSumClump(0, test4, 10));
    System.out.println(groupSumClump(0, test5, 14));
    System.out.println(groupSumClump(0, test6, 14));

  }
}
