import java.io.*;
import java.util.*;
public class Calculator{
 /*Evaluate a postfix expression stored in s.
 *Assume valid postfix notation, of ints doubles and operators separated by spaces.
 *Valid operators are + - / * and % (remainder not modulo)
 *All results are doubles even if the operands are both int.
 *@throws IllegalArgumentException when there are too many or too few operands.
 *        Use the string parameter of your exception to indicate what happened.
 *        Either "too many operands" or "too few operands for operation _" replace _ with +,- etc.
 */
 public static double eval(String s){
   Scanner postfix = new Scanner(s);
   ArrayDeque<Double> result = new ArrayDeque<Double>();
   while (postfix.hasNext()){
     String current = postfix.next();
     if (current.equals("+") || current.equals("-") || current.equals("*") || current.equals("/") || current.equals("%")){
       // if deque has more operations and no numbers, bad
       // if result.length == 0, return error; else do math yay
     }
     else { //this assumes valid math input ie no like letters like (4 3 / m + d -) or smth
       double addToDeque = Double.parseDouble(current);
       result.add(addToDeque);
     }
   }
   // if the deque has 2+ in deque by time u hit here, bad. if deque has more operations and no numbers, bad pt 2.
   return 110105;
 }
}
