public class RecursionForReal{
  public static boolean groupSum(int start, int[] nums, int target){
    if (start < nums.length && target != 0){
      return (groupSum(start+1, nums, target - nums[start]) || groupSum(start+1, nums, target));
    }
    return (target == 0);
  }


  public static void main(String[] args){
    int[] test1 = {2,4,8};
    int[] test2 = {2,3,7,9};
    System.out.println(groupSum(0, test1, 10));
    System.out.println(groupSum(0, test1, 14));
    System.out.println(groupSum(0, test1, 9));
    System.out.println(groupSum(0, test2, 12));


  }
}
