import java.util.*;
public class QueenBoard{
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){
        board[i][j] = 0;
      }
    }
  }



  /**------------------
  *@return The output string formatted as follows:
  *All numbers that represent queens are replaced with 'Q'
  *all others are displayed as underscores '_'
  *There are spaces between each symbol:
  *_ _ Q _
  *Q _ _ _
  *_ _ _ Q
  *_ Q _ _
  *excludes the characters up to the comment(*)
  */
  public String toString(){
    String shownBoard = "";
    for (int i = 0; i < board.length; i++){
      for (int j = 0; j < board[i].length; j++){ //since board square, cld have used board.length
        if (board[i][j] == -1){
          shownBoard += "Q";
        }
        else{
          shownBoard += "_";
        }
        if (j < board[i].length - 1){
          shownBoard += " ";
        }
      }
      if (i < board.length - 1){
        shownBoard += "\n";
      }
    }
    return shownBoard;
  }

  /**
  *@return true when the queen added correctly, false Otherwise
  *@precondition r and c are valid indices of the board array
  *@postcondition the board is only changed when the function returns true
  * in which case the queen is added and all it's threatened positions are incremented
  */

  //NOTE I CLD WRITE SMTH THAT CLD DO BOTH ADD N REMOVE N CALL IT LATER
  private boolean addQueen(int r, int c){
    if (board[r][c] != 0){
      return false;
    }
    else{
      board[r][c] = -1;
      int inc = 1;
      for (int newr = r + 1; newr < board.length; newr++){
        board[newr][c] += 1;
        if (c + inc < board.length){
          board[newr][c + inc] += 1;
        }
        if (c - inc >= 0){
          board[newr][c - inc] += 1;
        }
        inc++;
      }
    }
    return true;
  }

  /**Remove the queen that was added to r,c
  *@precondition r and c are valid indices of the board array and there is a queen at position r,c
  *@postcondition the board is modified to remove that queen and all it's
  *threatened positions are decremented
  */
  private void removeQueen(int r, int c){
    if (board[r][c] != -1){
    }
    else{
      // System.out.println("removing Queen from " + r + ", " + c);
      board[r][c] = 0;
      int inc = 1;
      for (int newr = r + 1; newr < board.length; newr++){
        board[newr][c] -= 1;
        if (c + inc < board.length){
          board[newr][c + inc] -= 1;
        }
        if (c - inc >= 0){
          board[newr][c - inc] -= 1;
        }
        inc++;
      }
    }
  }


  /**Find the first solution configuration possible for this size board. Start by placing
  *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
  *  move the previous queen to the next valid space. This means everyone will generate the same
  *  first solution.
  *@postcondition: the board remains in a solved state.
  *@return false when the board is not solveable and leaves the board filled with zeros;
  *        returns true when the board is solveable, and leaves the board in a solved state
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
  */

  public boolean solve(int row) throws IllegalStateException{ //throws IllegalStateException YAAA
    if (row == 0){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          if (board[i][j] != 0){
            throw new IllegalStateException("Not all 0s on board when trying to solve");
          }
        }
      }
    }
    if (row >= board.length){
      // System.out.println("Solution FOUND");
      return true;
    }
    else{
      for (int col = 0; col < board[row].length; col++){
        // System.out.println("testing addQueen at " + row + ", " + col);
        if (addQueen(row, col)){
          if (solve(row + 1)){
            return true;
          }
          removeQueen(row, col);
        }
      }
      return false;
    }
  }


  public boolean solve(){
    return solve(0);
  }


  /**Find all possible solutions to this size board.
  *@return the number of solutions found, and leaves the board filled with only 0's
  *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
  */


  public int countSolutions(int row) throws IllegalStateException{ //throws IllegalStateException YAAA
    if (row == 0){
      for (int i = 0; i < board.length; i++){
        for (int j = 0; j < board[i].length; j++){
          if (board[i][j] != 0){
            throw new IllegalStateException("Not all 0s on board when trying to solve");
          }
        }
      }
    }
    int counter = 0;
    if (row >= board.length){
      counter++;
    }
    else {
      for (int col = 0; col < board[row].length; col++){
        if (addQueen(row, col)){
          counter += countSolutions(row + 1);
          removeQueen(row, col);
        }
      }
    }
    return counter;
  }


  public int countSolutions(){
    return countSolutions(0);
  }


  public String debug(){
    String s = "";
    for (int i = 0; i < board.length; i++){
      s += Arrays.toString(board[i]) + "\n";
    }
    return s;
  }


  //---------------

  public static void main(String[] args){
    QueenBoard hi = new QueenBoard(8);
    System.out.println(hi);
    System.out.println(hi.debug());
    System.out.println(hi.solve());
    System.out.println(hi.debug());
    System.out.println(hi);
    System.out.println(" ");
    QueenBoard hi4 = new QueenBoard(4);
    System.out.println(hi4);
    System.out.println(hi4.solve());
    System.out.println(hi4.debug());
    System.out.println(hi4);
    QueenBoard hi2 = new QueenBoard(2);
    System.out.println(hi2);
    System.out.println(hi2.solve());
    System.out.println(hi2.debug());
    System.out.println(hi2);
    System.out.println(" ");
    System.out.println(" ");
    QueenBoard hi1new = new QueenBoard(1);
    System.out.println(hi1new.countSolutions());
    QueenBoard hi2new = new QueenBoard(2);
    System.out.println(hi2new.countSolutions());
    QueenBoard hi3new = new QueenBoard(3);
    System.out.println(hi3new.countSolutions());
    QueenBoard hi4new = new QueenBoard(4);
    System.out.println(hi4new.countSolutions());
    QueenBoard hi5new = new QueenBoard(5);
    System.out.println(hi5new.countSolutions());
    QueenBoard hi6new = new QueenBoard(6);
    System.out.println(hi6new.countSolutions());
    QueenBoard hi7new = new QueenBoard(7);
    System.out.println(hi7new.countSolutions());
    QueenBoard hi8new = new QueenBoard(8);
    System.out.println(hi8new.countSolutions());


    // System.out.println(hi.addQueen(1,1));
    // System.out.println(hi.debug());
    // System.out.println(hi);
    // // System.out.println(hi.addQueen(3,2));
    // // System.out.println(hi.debug());
    // // System.out.println(hi.addQueen(2,1));
    // // System.out.println(hi.debug());
    // // System.out.println(hi);
    //
    // System.out.println("");
    // hi.removeQueen(1,1);
    // System.out.println(hi.debug());
    // System.out.println(hi);
  }
}
