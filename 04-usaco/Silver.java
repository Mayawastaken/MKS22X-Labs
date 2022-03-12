import java.io.*;
import java.util.*;
public class Silver{




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
