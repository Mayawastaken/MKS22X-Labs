import java.util.*;
import java.io.*;
public class Bronze{

  public static int[][] stomp(int[][] toBeStomped, int stompAmount){
    int max = toBeStomped[0][0];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (toBeStomped[i][j] > max){
          toBeStomped[i][j] = max;
        }
      }
    }
    int afterStomp = max - stompAmount;
    int[][] stomped = new int[3][3];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (afterStomp < toBeStomped[i][j]){
          stomped[i][j] = afterStomp;
        }
        else{
          stomped[i][j] = toBeStomped[i][j];
        }
      }
    }
    return stomped;
  }

  public static long depthCalcuate(int[][] toCalc, int elevation){
    long sumDepth = 0l;
    for (int i = 0; i < toCalc.length; i++){
      for (int j = 0; i < toCalc[0].length; j++){ // see if u can have 0 rows in instructions aka no board bcs im taking toCalc[0]
        if (toCalc[i][j] < elevation){ //mkway smth very off um yuh
          sumDepth += elevation - toCalc[i][j];
        }
      }
    }
    return sumDepth * 72 * 72;
  }

  public static long solve(String filename) throws FileNotFoundException{ //might j make this solve
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
    int[][] toBeStomped = new int[3][3];
    for (int i = 0; i < numOfInst; i++){
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 3; k++){
          toBeStomped[i][j] = pasture[inst[i][0] + j - 1][inst[i][1] + k - 1]; //check -1/weird row col stuff
        }
      }
      stomp(toBeStomped, inst[i][2]);
      for (int j = 0; j < 3; j++){
        for (int k = 0; k < 3; k++){
          pasture[inst[i][0] + j - 1][inst[i][1] + k - 1] = toBeStomped[i][j];
        }
      }
    }
    return depthCalcuate(pasture, elevation);
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(solve("makelake.1.in"));
  }

}
