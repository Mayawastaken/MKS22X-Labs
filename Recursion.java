public class Recursion{
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length/size : either how many more letters or the total length depending on implementation
  *@param word/result : the partial word so far.
  */
  public static void printAllWords(int size,String result){
    if (size > 0){
      for (char i = 'a'; i <= 'e'; i++){
        printAllWords(size - 1, result + i);
      }
    }
    else{
      System.out.println(result);
    }
  }


  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int size,String result,char[]letters){
    if (size > 0){
      for (char letter : letters){
        if (result.lastIndexOf(letter) != result.length() - 1 || result.lastIndexOf(letter) == -1){
          printNoDoubleLetterWords(size - 1, result + letter, letters);
        }
      }
    }
    else{
      System.out.println(result);
    }
  }

  public static void main(String[] args){
    printAllWords(3);
    System.out.println("---------");
    char[] test1 = {'m','a','y'};
    printNoDoubleLetterWords(3, test1);

  }
}
