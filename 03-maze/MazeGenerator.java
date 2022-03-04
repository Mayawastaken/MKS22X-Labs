public class MazeGenerator{
  public static void generate(char[][]maze, int startrow, int startcol){
    //https://weblog.jamisbuck.org/2011/2/7/maze-generation-algorithm-recap
    // good algorithm ideas LOL -- only thing is, modify them so that instead of making "walls",
    // check if >1 ' 's already lead into the given # to create the "walls"
    if (startrow != maze.length && startcol != maze[0].length && maze[startrow][startcol] != ' '){
      // if (check if >2 ways in)
      //then make it a space, cont with algorithm / random
      //backtracking is when there are >2 ways in to all 3 adjacent directions, then u go back a square n try again from there
    }
  }
}
