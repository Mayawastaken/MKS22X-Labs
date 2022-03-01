import java.util.*;
import java.io.*;
public class Maze{
  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;

  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    String mazey = "";
    try{ //i dont need to try? LOL i mean like try keword n catch, instead it j knows it might need to throw
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int rows = 0;
      while (input.hasNextLine()){
        String line = input.nextLine();
        if (!line.equals("")){
          mazey += line + "\n"; //but not on the last one yk
          rows++;
        }
      }
      input.close();
      if (rows > 0){
        mazey = mazey.substring(0, mazey.length()-1);
      }
      int cols = 0;
      while (mazey.charAt(cols) != '\n'){
        cols++;
      }
      maze = new char[rows][cols];
      int place = 0;
      for (int i = 0; i < rows; i++){
        for (int j = 0; j < cols; j++){ // <= bcs of /n we want it to go to the end bcs itll never acc add when j = cols
          if (mazey.charAt(place) != '\n'){
            maze[i][j] = mazey.charAt(place);
          }
          else{
            j--;
          }
          place++;
        }
      }
    } catch (FileNotFoundException e) {
      //yo wrong filename
    }
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file with some characters replaced.
  */
  public String toString(){
    String showMaze = "";
    for (int i = 0; i < maze.length; i++){
      for (int j = 0; j < maze[i].length; j++){
        showMaze += maze[i][j];
      }
      if (i < maze.length - 1){
        showMaze += "\n";
      }
    }
    return showMaze;
  }

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol);

  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }

    //COMPLETE SOLVE
    return -1; //so it compiles
  }

  public static void main(String[] args){
    try{
      Maze test1 = new Maze("MazeA.txt");
      System.out.println(test1.toString());
    } catch (FileNotFoundException e) {

    }
  }
}