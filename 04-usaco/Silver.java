import java.io.*;
import java.util.*;
public class Silver{

  public static long[][] charToLongBuffer(char[][] field, int startRow, int startCol){
    long[][] numOfWays = new long[field.length + 2][field[0].length + 2];
    for (int i = 1; i < numOfWays.length-1; i++){
      for (int j = 1; j < numOfWays[0].length-1; j++){
        if (field[i-1][j-1] == '.'){
          numOfWays[i][j] = 0l;
        }
        else{
          numOfWays[i][j] = -1l;
        }
      }
    }
    numOfWays[startRow][startCol] = 1l; //THIS MEANS WE WANT t-1 SECONDS OF ITERATION OF newTime !!
    return numOfWays;
  }

  public static long[][] newTime(long[][] timeMinusOne){
    long[][] updatedNum = new long[timeMinusOne.length][timeMinusOne[0].length];
    long newWays = 0l;
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
          newWays = 0l;
        }
        else{
          updatedNum[i][j] = -1l;
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
    long[][] goodField = charToLongBuffer(field, startRow, startCol);
    int timer = 1; //bcs we alr added a 1 on ogField meaning 1 sec has passed
    while (timer < seconds){
      goodField = newTime(goodField);
      timer++;
    }
    return goodField[endRow][endCol];
  }
}
