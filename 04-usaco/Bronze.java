import java.util.*;
import java.io.*;
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

  public static int depthCalcuate(int[][] toCalc, int elevation){
    int sumDepth = 0;
    for (int i = 0; i < toCalc.length; i++){
      for (int j = 0; i < toCalc[0].length; j++){ // see if u can have 0 rows in instructions aka no board bcs im taking toCalc[0]
        if (toCalc[i][j] < elevation){
          sumDepth += elevation - toCalc[i][j];
        }
      }
    }
    return sumDepth * 72 * 72;
  }

  public static int[][] create(String filename) throws FileNotFoundException{ //might j make this solve
    File f = new File(filename);
    Scanner in = new Scanner(f);
    int row = in.nextInt();
    int col = in.nextInt();
    int[][] pasture = new int[row][col];
    int elevation = in.nextInt();
    int numOfInst = in.nextInt();
    int[][] inst = new int[numOfInst][3];
    for (int i = 0; i < row; i++){
      for (int j = 0; j < col; j++){
        pasture[i][j] = in.nextInt();
      }
    }
    for (int i = 0; i < numOfInst; i++){
      for (int j = 0; j < 3; j++){
        inst[i][j] = in.nextInt();
      }
    } //FINISHED READING IN EVERYTHING
    //basically use instructions, solve -- solve will j combine all funcs
    return (new int[][]{{}});
  }



  public static long solve(String filename){ // read it then use other helpers
    return 0l;
  }


}
