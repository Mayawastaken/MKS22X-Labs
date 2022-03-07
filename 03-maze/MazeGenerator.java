import java.util.*;
import java.io.*;
public class MazeGenerator{
  public static int[] newRCarray(int oldr, int oldc, int dir){
    int[] rc = new int[2];
    if (dir == 1){
      rc[0] = oldr - 1;
      rc[1] = oldc;
    }
    if (dir == 2){
      rc[0] = oldr;
      rc[1] = oldc + 1;
    }
    if (dir == 3){
      rc[0] = oldr + 1;
      rc[1] = oldc;
    }
    if (dir == 4){
      rc[0] = oldr;
      rc[1] = oldc - 1;
    }
    return rc;
  }

  public static void generateHelper(char[][]maze, int startrow, int startcol){
    String dir = "1234";
    Random r = new Random();
    //https://weblog.jamisbuck.org/2011/2/7/maze-generation-algorithm-recap
    // good algorithm ideas LOL -- only thing is, modify them so that instead of making "walls",
    // check if >1 ' 's already lead into the given # to create the "walls"
    if (startrow != 0 && startcol != 0 && startrow != maze.length - 1 && startcol != maze[0].length - 1 && maze[startrow][startcol] != ' '){
      int borderSpaces = 0;
      if (maze[startrow+1][startcol] == ' '){
        borderSpaces++;
      }
      if (maze[startrow-1][startcol] == ' '){
        borderSpaces++;
      }
      if (maze[startrow][startcol+1] == ' '){
        borderSpaces++;
      }
      if (maze[startrow][startcol-1] == ' '){
        borderSpaces++;
      }
      if (borderSpaces < 2){
        maze[startrow][startcol] = ' ';
        int dir1 = r.nextInt(4);
        int firstDir = Integer.parseInt(dir.charAt(dir1) + "");
        dir = dir.replace(dir.charAt(dir1) + "", "");
        int[] rc =  newRCarray(startrow, startcol, firstDir);
        generateHelper(maze, rc[0], rc[1]);
        //System.out.println(firstDir);

        int dir2 = r.nextInt(3);
        int secondDir = Integer.parseInt(dir.charAt(dir2) + "");
        dir = dir.replace(dir.charAt(dir2) + "", "");
        rc =  newRCarray(startrow, startcol, secondDir);
        generateHelper(maze, rc[0], rc[1]);
        //System.out.println(secondDir);


        int dir3 = r.nextInt(2);
        int thirdDir = Integer.parseInt(dir.charAt(dir3) + "");
        dir = dir.replace(dir.charAt(dir3) + "", "");
        rc =  newRCarray(startrow, startcol, thirdDir);
        generateHelper(maze, rc[0], rc[1]);
        //System.out.println(thirdDir);


        int fourthDir = Integer.parseInt(dir);
        rc =  newRCarray(startrow, startcol, fourthDir);
        generateHelper(maze, rc[0], rc[1]);
        //System.out.println(fourthDir); random 4 dir work confirmed
      }
    }
  }


  public static void generate(char[][]maze, int startrow, int startcol){
    generateHelper(maze, startrow, startcol);
    maze[startrow][startcol] = 'S';
    int rowE, colE, incrementRow, incrementCol;
    if (Math.abs((maze.length - 2)  - startrow) <= Math.abs(startrow - 1)){
      rowE = 1;
      incrementRow = 1;
    }
    else{
      rowE = maze.length - 2;
      incrementRow = -1;
    }
    if (Math.abs((maze[0].length - 2)  - startcol) <= Math.abs(startcol - 1)){
      colE = 1;
      incrementCol = 1;
    }
    else{
      colE = maze[0].length - 2;
      incrementCol = -1;
    }
    if (maze[rowE][colE] == ' '){
      maze[rowE][colE] = 'E';
    }
    else{
      nestedloop:
      for (int i = rowE; i < maze.length - 1 && i > 0; i += incrementRow){
        for (int j = colE; j < maze[0].length - 1 && j > 0; j += incrementCol){
          if (maze[i][j] == ' '){
            maze[i][j] = 'E';
            break nestedloop;
          }
        }
      }
    }
  }


  public static void main(String[] args){
    // char[][] maze1 = new char[12][10];
    // for (int i = 0; i < maze1.length; i++){
    //   for (int j = 0; j < maze1[0].length; j++){
    //     maze1[i][j] = '#';
    //   }
    // }
    //
    // generate(maze1, 3, 3);
    // String showMaze1 = "";
    // for (int i = 0; i < maze1.length; i++){
    //   for (int j = 0; j < maze1[i].length; j++){
    //     showMaze1 += maze1[i][j];
    //   }
    //   if (i < maze1.length - 1){
    //     showMaze1 += "\n";
    //   }
    // }
    // System.out.println(showMaze1);
  }
}
