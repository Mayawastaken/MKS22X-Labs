public class Bronze{

  public static int[] stomp(int[] toBeStomped, int stompAmount){
    int max = toBeStomped[0];
    for (int i = 0; i < toBeStomped.length; i++){ //len shld always be 9
      if (toBeStomped[i] > max){
        toBeStomped[i] = max;
      }
    }
    int afterStomp = max - stompAmount;
    int[] stomped = new int[toBeStomped.length];
    for (int i = 0; i < toBeStomped.length; i++){ //len shld always be 9
      if (afterStomp < toBeStomped[i]){
        stomped[i] = afterStomp;
      }
      else{
        stomped[i] = toBeStomped[i];
      }
    }
    return stomped;
  }

  public static int[] create(){
    //basically use instructions, solve -- solve will j combine all funcs
    return (new int[]{0});
  }


  public static long solve(String filename){ // read it then use other helpers
    return 0l;
  }


}
