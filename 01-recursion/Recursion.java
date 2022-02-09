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

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    char[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    if (length > 0){
      for (char letter : letters){
        if (word.lastIndexOf(letter) != word.length() - 1 || word.lastIndexOf(letter) == -1){
          return 1l + countNoDoubleLetterWords(length - 1, word + letter); // BADD
        }
      }
    }
    else{
      return 1l;
    }
    return 1l;
  } //okay i did this thru github in class since terminal no load after 18 min bad tried 2 computers

  /*
  *@param s any string
  *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
  */
  public static String reverse(String s){
    if (s.length() > 1){
      return reverse(s.substring(1)) + s.charAt(0);
    }
    else{
      return s;
    }
  }


  public static double sqrt(double n, double guess){
    if (Math.abs((guess * guess - n)/(guess * guess)) >= .00001){
      //System.out.println(guess);
      return sqrt(n, (n*1.0/guess + guess)/2.0);
    }
    else{
      return guess;
    }
  }
  /*
  *@param n any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n){
    return sqrt(n, 1);
  }

  /*
  *@param n any non-negative value
  *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
  */
  public static int fibIter(int n, int f1, int f2){
    if (n > 1){
      return fibIter(n-1, f1 + f2, f1);
    }
    else if (n == 1){
      return f1;
    }
    else{
      return f2;
    }
  }
    //DO NOT call fibIter more than once


  public static void main(String[] args){
    printAllWords(3);
    System.out.println("---------");
    char[] test1 = {'m','a','y'};
    printNoDoubleLetterWords(3, test1);
    System.out.println("---------");
    System.out.println(reverse("Hey I'm Maya"));
    System.out.println("---------");
    System.out.println(countNoDoubleLetterWords(3, ""));
    System.out.println("---------");
    System.out.println(fibIter(0, 1, 0));
    System.out.println(fibIter(1, 1, 0));
    System.out.println(fibIter(2, 1, 0));
    System.out.println(fibIter(3, 1, 0));
    System.out.println(fibIter(4, 1, 0));
    System.out.println(fibIter(5, 1, 0));
    System.out.println(fibIter(6, 1, 0));
    System.out.println(fibIter(7, 1, 0));
    System.out.println("---------");
    System.out.println(sqrt(100));
    System.out.println(sqrt(16));
    System.out.println(sqrt(2));
    System.out.println("---------");
  }
}
