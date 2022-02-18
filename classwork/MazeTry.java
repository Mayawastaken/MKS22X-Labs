import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeTry{
  private int lines;

  public static String readInString(String filename){
    String maze = "";
    try{
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int lines = 0;
      while (input.hasNextLine()){
        String line = input.nextLine();
        if (!line.equals("")){
          maze += line + "\n"; //but not on the last one yk
          lines++;
        }
      }
      input.close();
    } catch (FileNotFoundException e) {
      //yo wrong filename
    }
    return maze;
  }

  public static void main(String[] args){
    try{
      String fileWanted = args[0];
      System.out.println(readInString(fileWanted));
    } catch (ArrayIndexOutOfBoundsException ex){
      System.out.println("no acceptable file given");
    }

  }
}
