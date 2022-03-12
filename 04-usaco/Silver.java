import java.io.*;
import java.util.*;
public class Silver{

  public static int[][] charToIntBuffer(char[][] field){
    int[][] numOfWays = new int[field.length + 2][field[0].length + 2];
    for (int i = 1; i < numOfWays.length-1; i++){
      for (int j = 1; j < numOfWays[0].length-1; j++){
        if (field[i-1][j-1] == '.'){
          numOfWays[i][j] = 0;
        }
        else{
          numOfWays[i][j] = -1;
        }
      }
    }
    return numOfWays;
  }

  public static int[][] newTime(int[][] timeMinusOne){
    int[][] updatedNum = new int[timeMinusOne.length][timeMinusOne[0].length];
    int newWays = 0;
    for (int i = 0; i < timeMinusOne.length; i++){
      for (int j = 0; j < timeMinusOne[0].length; j++){
        if (timeMinusOne[i][j] != -1){
          if (timeMinusOne[i+1][j] != -1){
            newWays += timeMinusOne[i+1][j];
          }
          if (timeMinusOne[i-1][j] != -1){
            newWays += timeMinusOne[i-1][j];
          }
          if (timeMinusOne[i][j+1] != -1){
            newWays += timeMinusOne[i][j+1];
          }
          if (timeMinusOne[i][j-1] != -1){
            newWays += timeMinusOne[i][j-1];
          }
          updatedNum[i][j] = newWays;
          newWays = 0;
        }
        else{
          updatedNum[i][j] = -1;
        }
      }
    }
    return updatedNum;
  }



  public static long solve(String filename) throws FileNotFoundException{
    File f = new File(filename);
    Scanner in = new Scanner(f);
    int row = in.nextInt();
    int col = in.nextInt();
    char[][] field = new char[row][col];
    int seconds = in.nextInt();
    for (int i = 0; i < row; i++){
      for (int j = 0; j < col; j++){
        field[i][j] = in.nextChar();
      }
    }
    int startRow = in.nextInt();
    int startCol = in.nextInt();
    int endRow = in.nextInt();
    int endCol = in.nextInt();

  }
}
