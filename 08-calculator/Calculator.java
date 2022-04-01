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
       if (result.size() < 2){
         throw new IllegalArgumentException("too few operands for operation " + current);
       }
       else{
         double afterOperator = result.removeLast();
         double beforeOperator = result.removeLast();
         if (current.equals("+")){
           result.addLast((beforeOperator + afterOperator));
         }
         if (current.equals("-")){
           result.addLast((beforeOperator - afterOperator));
         }
         if (current.equals("/")){
           result.addLast((beforeOperator * 1.0 / afterOperator));
         }
         if (current.equals("*")){
           result.addLast((beforeOperator * afterOperator));
         }
         if (current.equals("%")){
           result.addLast((beforeOperator * 1.0 % afterOperator));
         }
         // convert current to operator
       }
     }
     else { //this assumes valid math input ie no like letters like (4 3 / m + d -) or smth
       double addToDeque = Double.parseDouble(current);
       result.add(addToDeque);
     }
   }
   if (result.size() > 1){
     throw new IllegalArgumentException("too many operands");
   }
   return result.getFirst();
 }


 public static void main(String[] args){
   String s1 = "4 2 + 3 5 1 - * +";
   System.out.println(eval(s1));
 }
}
