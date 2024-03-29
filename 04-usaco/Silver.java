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
    numOfWays[startRow][startCol] = 1l;
    return numOfWays;
  }

  public static long[][] newTime(long[][] timeMinusOne){
    long[][] updatedNum = new long[timeMinusOne.length][timeMinusOne[0].length];
    long newWays = 0l;
    for (int i = 0; i < timeMinusOne.length; i++){
      for (int j = 0; j < timeMinusOne[0].length; j++){
        if (timeMinusOne[i][j] != -1 && i != 0 && i != timeMinusOne.length - 1 && j != 0 && j != timeMinusOne[0].length - 1){
          //basically not border or tree
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
    try{
      File f = new File(filename);
      Scanner in = new Scanner(f);
      int row = in.nextInt();
      int col = in.nextInt();
      char[][] field = new char[row][col];
      int seconds = in.nextInt();
      for (int i = 0; i < field.length; i++){
        String line = in.next();
        field[i] = line.toCharArray();
      }
      int startRow = in.nextInt();
      int startCol = in.nextInt();
      int endRow = in.nextInt();
      int endCol = in.nextInt();
      long[][] goodField = charToLongBuffer(field, startRow, startCol);
      int timer = 0;
      while (timer < seconds){
        goodField = newTime(goodField);
        timer++;
      }
      return goodField[endRow][endCol];
    } catch (FileNotFoundException e) {
      return -1;
    }
  }

  public static void main(String[] args) throws FileNotFoundException{
    System.out.println(solve("ctravel.1.in"));
    System.out.println(solve("ctravel.2.in"));
  }
}
