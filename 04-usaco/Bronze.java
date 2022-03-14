import java.util.*;
import java.io.*;
public class Bronze{

  public static int[][] stomp(int[][] toBeStomped, int stompAmount){ //THIS WORKS
    int max = toBeStomped[0][0];
    for (int i = 0; i < 3; i++){
      for (int j = 0; j < 3; j++){
        if (toBeStomped[i][j] > max){
          max = toBeStomped[i][j];
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
      for (int j = 0; j < toCalc[0].length; j++){ // see if u can have 0 rows in instructions aka no board bcs im taking toCalc[0]
        if (toCalc[i][j] < elevation){ //mkway smth very off um yuh
          sumDepth += elevation - toCalc[i][j];
        }
      }
    }
    return sumDepth * 72 * 72;
  }

  // public static String debug(int[][] print){
  //   String s = "";
  //   for (int[] row : print){
  //     for (int x : row){
  //       s += x + " ";
  //     }
  //     s += "\n";
  //   }
  //   return s;
  // }

  public static long solve(String filename) throws FileNotFoundException{ //might j make this solve
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int row = in.nextInt();
      // System.out.println(row);
      int col = in.nextInt();
      // System.out.println(col);
      int[][] pasture = new int[row][col];
      int elevation = in.nextInt();
      // System.out.println(elevation);
      int numOfInst = in.nextInt();
      // System.out.println(numOfInst);
      int[][] inst = new int[numOfInst][3];
      for (int i = 0; i < row; i++){
        for (int j = 0; j < col; j++){
          pasture[i][j] = in.nextInt();
          //System.out.print(pasture[i][j] + " ");
        }
        //System.out.println("");
      }
      //System.out.println("");
      for (int i = 0; i < numOfInst; i++){
        for (int j = 0; j < 3; j++){
          inst[i][j] = in.nextInt();
          //System.out.print(inst[i][j] + " ");
        }
        //System.out.println("");
      } //FINISHED READING IN EVERYTHING
      //basically use instructions, solve -- solve will j combine all funcs
      int[][] toBeStomped = new int[3][3];
      for (int i = 0; i < numOfInst; i++){
        for (int j = 0; j < 3; j++){
          for (int k = 0; k < 3; k++){
            toBeStomped[j][k] = pasture[inst[i][0] + j - 1][inst[i][1] + k - 1]; //check -1/weird row col stuff
          }
        }
        // System.out.println("\n TO BE: \n" + debug(toBeStomped));
        int[][] stomped = stomp(toBeStomped, inst[i][2]);
        // System.out.println("STOMPED: \n" + debug(stomped));
        for (int j = 0; j < 3; j++){
          for (int k = 0; k < 3; k++){
            pasture[inst[i][0] + j - 1][inst[i][1] + k - 1] = stomped[j][k];
          }
        }
        // System.out.println("NEW PASTURE: \n" + debug(pasture));
      }
      return depthCalcuate(pasture, elevation);
    } catch (FileNotFoundException e){
      return -1;
    }
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(solve("makelake.1.in"));
    System.out.println(solve("makelake.2.in"));
  }

}
